(ns monolith.view.layout.application
  (:require [rum.core :as rum]))

(rum/defc template [body]
  [:html
   [:head]
   [:body
    body
    [:script {:src "/js/main.js"}]]])
