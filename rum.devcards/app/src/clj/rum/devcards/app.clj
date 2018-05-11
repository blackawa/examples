(ns rum.devcards.app
  (:require [com.stuartsierra.component :as component]
            [figwheel-sidecar.system :as figwheel]))

(defn system []
  (component/system-map
   :figwheel (figwheel/figwheel-system (figwheel/fetch-config))))
