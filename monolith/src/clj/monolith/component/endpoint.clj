(ns monolith.component.endpoint
  (:require [integrant.core :as ig]
            [bidi.ring :refer [make-handler]]))

(defmethod ig/init-key :monolith.component/endpoint [_ {:keys [handlers routes middleware]}]
  (-> routes
      (make-handler #(handlers %))
      middleware))
