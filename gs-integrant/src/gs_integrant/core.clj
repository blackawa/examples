(ns gs-integrant.core
  (:gen-class)
  (:require [integrant.core :as ig]
            [ring.adapter.jetty :as jetty]
            [ring.util.response :as resp]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def config
  {:adapter/jetty {:port 8080 :handler (ig/ref :handler/greet)}
   :handler/greet {:name "alice"}})

(defmethod ig/init-key :adapter/jetty [_ {:keys [handler] :as opts}]
  (let [server (jetty/run-jetty handler (-> opts (dissoc :handler) (assoc :join? false)))]
    (println server)
    server))

(defmethod ig/halt-key! :adapter/jetty [_ server]
  (println server)
  (.stop server))

(defmethod ig/init-key :handler/greet [_ {:keys [name]}]
  (fn [_] (resp/response (str "Hello " name))))
