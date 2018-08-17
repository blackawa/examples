(ns monolith.component.routes
  (:require [integrant.core :as ig]))

(defmethod ig/init-key :monolith.component/routes [_ routes]
  routes)
