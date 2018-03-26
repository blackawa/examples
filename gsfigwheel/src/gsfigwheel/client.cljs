(ns gsfigwheel.client
  (:require [accountant.core :as accountant]
            [bidi.bidi :as bidi]
            [rum.core :as rum]
            [gsfigwheel.flow :as flow]
            [gsfigwheel.router :refer [routes]]
            [gsfigwheel.view :as view]))

(enable-console-print!)

(println "Hello from cljs!")

(def handlers
  {:site.home/index view/+home
   :site.about/index view/+about})

(when-let [app (js/document.getElementById "app")]
  (accountant/configure-navigation!
   {:nav-handler (fn [path]
                   (flow/dispatch :handler (get handlers
                                                (:handler (bidi/match-route routes path)))))
    :path-exists? (fn [path]
                    (boolean (bidi/match-route routes path)))})
  (accountant/dispatch-current!)
  (add-watch flow/state :handler-readiness
             (fn [k a old new]
               (when (boolean (:handler new))
                 (remove-watch flow/state :handler-readiness)
                 (rum/mount (view/+app flow/state) app)))))
