(ns rum.devcards.component.block
  (:require [rum.core :as rum]))

(rum/defc block < rum/reactive []
  [:span.block "block"])
