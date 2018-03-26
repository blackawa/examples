(ns gsfigwheel.flow
  (:require [cljs.core.async :as a])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(defonce state (atom {:count 0}))
(defonce actions (a/chan))

(defn dispatch
  ([type] (dispatch type nil))
  ([type data]
   (a/put! actions [type data])))

(defmulti transform
  (fn [state data dispatch action-type] action-type))

(defmethod transform :increment-counter
  [state _value]
  (update-in state [:count] inc))

(defmethod transform :handler
  [state value]
  (assoc state :handler value))

(go-loop []
  (when-let [a (a/<! actions)]
    (let [[type data] a]
      (println "Handle action" type)
      (swap! state transform data dispatch type))
    (recur)))
