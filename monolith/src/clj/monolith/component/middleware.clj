(ns monolith.component.middleware
  (:require [integrant.core :as ig]
            [muuntaja.middleware :refer [wrap-format]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults site-defaults]]
            [monolith.component.logger :refer [wrap-log]]))

(defmethod ig/init-key :monolith.component/middleware [_ {:keys [logger dev?]}]
  (fn [handler] (-> handler
                    ;; FIXME: /apiならapi-defaults, /ならsite-defaults
                    (wrap-defaults api-defaults)
                    wrap-format
                    (wrap-log logger))))
