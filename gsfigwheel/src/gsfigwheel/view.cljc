(ns gsfigwheel.view
  (:require [rum.core :as rum]
            #?(:cljs [accountant.core :as accountant])
            #?(:cljs [gsfigwheel.flow :as flow])))

(defn +layout
  ([state]
   (+layout state nil))
  ([state body]
   [:html
    [:head [:link {:rel "stylesheet" :href "https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css"}]]
    [:body
     [:section.section
      [:.container
       [:#app
        (if body
          {:dangerouslySetInnerHTML {:__html body}}
          [:h1.title.is-4 "Change me with your React wrapper!!"])]]]
     [:script {:defer true
               :src "https://use.fontawesome.com/releases/v5.0.8/js/solid.js"
               :integrity "sha384-+Ga2s7YBbhOD6nie0DzrZpJes+b2K1xkpKxTFFcx59QmVPaSA8c7pycsNaFwUK6l"
               :crossorigin "anonymous"}]
     [:script {:defer true
               :src "https://use.fontawesome.com/releases/v5.0.8/js/fontawesome.js"
               :integrity "sha384-7ox8Q2yzO/uWircfojVuCQOZl+ZZBg2D2J5nkpLqzH1HY0C1dHlTKIbpRz/LG23c"
               :crossorigin "anonymous"}]
     [:script {:src "/js/example.js"}]]]))

(rum/defc +home < rum/reactive [state]
  [:.content
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
