(ns monolith.handler.not-found
  (:require [integrant.core :as ig]
            [monolith.util.response :as res]))

(defmethod ig/init-key ::index [_ _]
  ;; FIXME: acceptヘッダーを見て内容を変える
  (fn [req]
    (-> {:status 404 :body "Not found"}
        res/html)))
