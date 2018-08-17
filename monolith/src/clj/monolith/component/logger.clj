(ns monolith.component.logger
  (:require [integrant.core :as ig]
            [taoensso.timbre :as timbre]))

(defprotocol Logger
  (log [this level message data]))

(defrecord TimbreLogger [config]
  Logger
  (log [this level message data]
    (timbre/log* config level message data)))

(defmethod ig/init-key :monolith.component/logger [_ options]
  (map->TimbreLogger
   {:config
    (assoc options :appenders {:println (timbre/println-appender)})}))

(defn wrap-log [handler logger]
  (fn [req]
    (log logger :debug ::receive-request req)
    (try
      (handler req)
      (catch Exception e
        (log logger :fatal ::unexpected-exception {:exception e})
        (throw e)))))
