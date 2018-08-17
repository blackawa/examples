(ns monolith.util.response)

(defn ok [body]
  {:status 200
   :body body})

(defn html [res]
  (assoc-in res [:headers "Content-Type"] "text/html;charset=utf-8"))
