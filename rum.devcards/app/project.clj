(defproject rum.devcards/app "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [com.stuartsierra/component "0.3.2"]
                 [rum "0.11.2"]]
  :source-paths ["src/clj"]
  :profiles {:dev {:dependencies [[devcards "0.2.4"]
                                  [figwheel-sidecar "0.5.16"]
                                  [org.clojure/tools.namespace "0.2.11"]
                                  [com.stuartsierra/component.repl "0.2.0"]]
                   :source-paths ["dev"]}})
