(ns rum.devcards.component.figwheel
  (:require [integrant.core :as ig]
            [figwheel-sidecar.system :as system]
            [figwheel-sidecar.components.figwheel-server :as server]))

(defmethod ig/init-key :rum.devcards.component/figwheel [_ config]
  (let [server (-> config
                   server/figwheel-server
                   (system/add-initial-builds ["dev"]))]
    (println server)
    server))
