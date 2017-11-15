(ns ring-atarxy-tryout.core
  (:gen-class)
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response]
            [ring.adapter.jetty :refer [run-jetty]]))

;;; Ataraxy routing

(def routes '{"/products"
              {[:get] [:products/list]
               [:get "/" pid] [:products/get ^uuid pid]
               [:get "/search" #{q}] [:products/search q]
               [:post {body :body}] [:products/new body]}})

;;; Handlers

(defn- products-list [req]
  [::response/ok (str "Hello")])

(defn- products-get [req])

(defn- products-search [req])

(defn- products-new [req])

(def handler (ataraxy/handler
              {:routes routes
               :handlers {:products/list products-list
                          :products/get products-get
                          :products/search products-search
                          :products/new products-new}}))

;;; Ring server

(defonce server (atom nil))

(defn start []
  (when-not @server
    (reset! server (run-jetty #'handler {:port 3000 :join? false}))))

(defn stop []
  (when @server
    (.stop @server)
    (reset! server nil)))
