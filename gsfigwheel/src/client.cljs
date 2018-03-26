(ns gsfigwheel.client
  (:require [accountant.core :as accountant]
            [bidi.bidi :as bidi]
            [cljs.core.async :refer [<! timeout]]
            [rum.core :as rum]
            [gsfigwheel.flow :as flow]
            [gsfigwheel.view :as view])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(enable-console-print!)

(println "Hello from cljs!")

(when-let [app (js/document.getElementById "app")]
  (accountant/configure-navigation!
   {:nav-handler (fn [path]
                   (flow/dispatch :handler (get view/handlers
                                                (:handler (bidi/match-route view/routes path)))))
    :path-exists? (fn [path]
                    (boolean (bidi/match-route view/routes path)))})
  (go
    (accountant/dispatch-current!)
    (<! (timeout 1000))
    (rum/mount (view/+app flow/state) app)))
