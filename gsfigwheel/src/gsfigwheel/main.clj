(ns gsfigwheel.main
  (:require [bidi.ring :as br]
            [com.stuartsierra.component :as component]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [rum.core :as rum]
            [system.components.endpoint :refer [new-endpoint]]
            [system.components.handler :refer [new-handler]]
            [system.components.jetty :refer [new-jetty]]
            [system.components.middleware :refer [new-middleware]]
            [gsfigwheel.router :refer [routes]])
  (:import [gsfigwheel.controller HomeController AboutController]))

(defn keyword->handler
  "find ring handler from m(ap) argument."
  [m]
  (extend-protocol br/Ring
    clojure.lang.Keyword
    (request [k req _]
      (let [handler (get-in m [k :controller])]
        (handler req)))))

(defn endpoint [component]
  (keyword->handler component)
  routes)

(defn +layout [state]
  [:html
   [:head [:link {:rel "stylesheet" :href "https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css"}]]
   [:body
    [:section.section
     [:.container
      [:#app [:h1.title.is-4 "Change me with your React wrapper!"]]]]
    [:script {:defer true
              :src "https://use.fontawesome.com/releases/v5.0.8/js/solid.js"
              :integrity "sha384-+Ga2s7YBbhOD6nie0DzrZpJes+b2K1xkpKxTFFcx59QmVPaSA8c7pycsNaFwUK6l"
              :crossorigin "anonymous"}]
    [:script {:defer true
              :src "https://use.fontawesome.com/releases/v5.0.8/js/fontawesome.js"
              :integrity "sha384-7ox8Q2yzO/uWircfojVuCQOZl+ZZBg2D2J5nkpLqzH1HY0C1dHlTKIbpRz/LG23c"
              :crossorigin "anonymous"}]
    [:script {:src "/js/example.js"}]]])

(defn system []
  (component/system-map
   :http (component/using (new-jetty :port 3000) [:handler])
   :handler (component/using (new-handler :router :bidi) [:endpoint :middleware])
   :middleware (new-middleware {:middleware [[wrap-defaults site-defaults]]})
   :endpoint (component/using (new-endpoint endpoint) [:site.home/index :site.about/index])
   :site.home/index (HomeController.)
   :site.about/index (AboutController.)))
