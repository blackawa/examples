(defproject rum.devcards "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [integrant "0.6.3"]]
  :source-paths ["src/clj"]
  :profiles {:dev {:source-paths ["dev/src"]
                   :dependencies [[figwheel-sidecar "0.5.16"]
                                  [integrant/repl "0.3.1"]]}})
