(ns monolith.boundary.dog
  (:require [clojure.java.jdbc :as jdbc]
            [duct.database.sql]
            [honeysql.core :as sql]))

(defprotocol Dog
  (fetch-all [this]))

(extend-protocol Dog
  duct.database.sql.Boundary
  (fetch-all [{:keys [spec]}]
    (jdbc/query spec (sql/format {:select [:*] :from [:dogs] :order-by [:id]}))))
