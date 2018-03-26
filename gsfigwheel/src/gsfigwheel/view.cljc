(ns gsfigwheel.view
  (:require [rum.core :as rum]
            #?(:cljs [accountant.core :as accountant])
            #?(:cljs [gsfigwheel.flow :as flow])))

(rum/defc +home < rum/reactive [state]
  [:.content
   [:p "Current state:" (str (rum/react state))]
   [:p "Click count:" (:count (rum/react state))]
   [:button.button.is-link #?(:cljs {:on-click #(flow/dispatch :increment-counter)}) "Click me!"]])

(rum/defc +about [state]
  [:.card
   [:.card-content
    [:p "This is about page."]]])

(rum/defc +app < rum/reactive [state]
  [:div
   [:.tabs
    [:ul
     [:li [:a {:href "/index.html" :on-click #?(:clj nil :cljs #(accountant/navigate! "/index.html"))} "Home"]]
     [:li [:a {:href "/about.html" :on-click #?(:clj nil :cljs #(accountant/navigate! "/about.html"))} "About"]]]]
   ((:handler (rum/react state)) state)])
