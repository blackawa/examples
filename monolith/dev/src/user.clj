(ns user
  (:require [integrant.core :as ig]
            [integrant.repl :refer [clear go halt prep init reset reset-all set-prep!]]
            [monolith.core :as app]))

(let [config (app/config {:profile :dev})]
  (-> config
      constantly
      set-prep!)
  (ig/load-namespaces config))
