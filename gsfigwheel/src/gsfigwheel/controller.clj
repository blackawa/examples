(ns gsfigwheel.controller
  (:require [com.stuartsierra.component :as component]
            [gsfigwheel.main :as main]
            [rum.core :as rum]))

(defn- rum-ok [body]
  (-> {:body (rum/render-static-markup body)}
      (assoc-in [:headers "Content-Type"] "text/html; charset=utf-8")))

(defrecord HomeController []
  component/Lifecycle
  (start [component]
    (assoc component :controller (fn [_] (rum-ok (main/+layout (atom {}))))))
  (stop [component] (dissoc component :controller)))

(defrecord AboutController []
  component/Lifecycle
  (start [component]
    (assoc component :controller (fn [_] (rum-ok (main/+layout (atom {}))))))
  (stop [component] (dissoc component :controller)))
