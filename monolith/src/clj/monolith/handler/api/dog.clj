(ns monolith.handler.api.dog
  (:require [integrant.core :as ig]
            [monolith.boundary.dog :as dog]))

(defmethod ig/init-key ::index [_ {:keys [db]}]
  (fn [req] {:status 200 :body {:dogs (dog/fetch-all db)}}))
