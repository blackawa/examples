(ns monolith.view.top.index
  (:require [rum.core :as rum]
            [monolith.view.layout.application :as layout]))

(rum/defc template []
  (layout/template [:h1 "Hello world"]))
