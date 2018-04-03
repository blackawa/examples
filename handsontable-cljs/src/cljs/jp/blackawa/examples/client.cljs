(ns jp.blackawa.examples.client
  (:require [cljsjs.jquery]
            [cljsjs.handsontable]))

(enable-console-print!)

(println "Hello from cljs!")

;; initialize handsontable

(defonce handsontable (atom nil))

(def clients
  [{:name "マート黒川支店" :name_kana "マートクロカワシテン" :login_id "black1"
    :password "password1" :place1 "千葉県袖ケ浦市今井1-2-3" :place2 nil}])

(def settings
  (clj->js {:data clients
            :colHeaders ["店舗名" "店舗名カナ" "ログインユーザーID" "パスワード" "住所1" "住所2"]
            :columns [{:data "name"} {:data "name_kana"} {:data "login_id"}
                      {:data "password"} {:data "place1"} {:data "place2"}]}))

(when-let [app (js/document.getElementById "app")]
  (js/Handsontable app settings))
