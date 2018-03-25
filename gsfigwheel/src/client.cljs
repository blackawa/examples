(ns gsfigwheel.client
  (:require [accountant.core :as accountant]
            [bidi.bidi :as bidi]
            [rum.core :as rum]
            [gsfigwheel.view :as view]))

(enable-console-print!)

(println "Hello from cljs!")

(def state (atom {:count 0}))

(when-let [app (js/document.getElementById "app")]
  (accountant/configure-navigation!
   {:nav-handler (fn [path]
                   (swap! state assoc :handler (get view/handlers
                                                    (:handler (bidi/match-route view/routes path)))))
    :path-exists? (fn [path]
                    (boolean (bidi/match-route view/routes path)))})
  (accountant/dispatch-current!)
  (rum/mount (view/+app state) app))
