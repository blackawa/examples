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

(defn system []
  (component/system-map
   :http (component/using (new-jetty :port 3000) [:handler])
   :handler (component/using (new-handler :router :bidi) [:endpoint :middleware])
   :middleware (new-middleware {:middleware [[wrap-defaults site-defaults]]})
   :endpoint (component/using (new-endpoint endpoint) [:site.home/index :site.about/index])
   :site.home/index (HomeController.)
   :site.about/index (AboutController.)))
