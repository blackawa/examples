(ns monolith.handler.top
  (:require [integrant.core :as ig]))

(defmethod ig/init-key ::index [_ _]
  (fn [req] {:status 200 :headers {"Content-Type" "text/html"} :body "<h1>Hello~</h1>"}))
