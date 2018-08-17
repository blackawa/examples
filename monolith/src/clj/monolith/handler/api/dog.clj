(ns monolith.handler.api.dog
  (:require [integrant.core :as ig]))

(defmethod ig/init-key ::index [_ _]
  (fn [req] {:status 200 :body {:dogs [{:name "Gon"} {:name "Sasuke"}]}}))
