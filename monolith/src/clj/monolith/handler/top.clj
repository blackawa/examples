(ns monolith.handler.top
  (:require [integrant.core :as ig]
            [rum.core :as rum]
            [monolith.util.response :as res]
            [monolith.view.top.index :as index]))

(defmethod ig/init-key ::index [_ _]
  (fn [req]
    (-> (res/ok (rum/render-html (index/template)))
        res/html)))
