(ns monolith.component.middleware
  (:require [integrant.core :as ig]
            [muuntaja.middleware :refer [wrap-format]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults site-defaults]]
            [monolith.component.logger :refer [wrap-log]]))

(defn wrap-api-or-site-defaults [handler]
  (fn [req]
    (let [defaults (if (clojure.string/starts-with? (:uri req) "/api")
                     api-defaults
                     site-defaults)]
      ((wrap-defaults handler defaults) req))))

(defmethod ig/init-key :monolith.component/middleware [_ {:keys [logger dev?]}]
  (fn [handler] (-> handler
                    wrap-api-or-site-defaults
                    wrap-format
                    (wrap-log logger))))
