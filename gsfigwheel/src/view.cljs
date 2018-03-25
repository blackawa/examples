(ns gsfigwheel.view
  (:require [accountant.core :as accountant]
            [rum.core :as rum]))

(rum/defc +home < rum/reactive [state]
  [:div
   [:p "Current state:" (str (rum/react state))]
   [:p "Click count:" (:count (rum/react state))]
   [:button {:on-click #(swap! state update-in [:count] inc)} "Click me!"]])

(rum/defc +about [state]
  [:.card
   [:.card-content
    [:p "This is about page."]]])

(rum/defc +app < rum/reactive [state]
  [:div
   [:.tabs
    [:ul
     [:li [:a {:href "/index.html" :on-click #(accountant/navigate! "/index.html")} "Home"]]
     [:li [:a {:href "/about.html" :on-click #(accountant/navigate! "/about.html")} "About"]]]]
   ((:handler (rum/react state)) state)])

(def routes
  ["/" {"index.html" :site.home/index
        "about.html" :site.about/index}])

(def handlers
  {:site.home/index +home
   :site.about/index +about})
