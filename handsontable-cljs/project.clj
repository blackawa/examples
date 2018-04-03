(defproject jp.blackawa.examples/handsontable-cljs "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "TODO: Choose a license"
            :url "http://choosealicense.com/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.4.474"]
                 [org.clojure/clojurescript "1.10.238"]
                 [org.danielsz/system "0.4.1"]
                 [com.stuartsierra/component "0.3.2"]
                 [duct/ragtime-component "0.1.4"]
                 [org.clojure/java.jdbc "0.7.5"]
                 [org.postgresql/postgresql "42.1.4"]
                 [hikari-cp "2.2.0"]
                 [honeysql "0.9.2"]
                 [ring "1.6.3"]
                 [ring/ring-defaults "0.3.1"]
                 [metosin/muuntaja "0.5.0"]
                 [bidi "2.1.3"]
                 [rum "0.11.2"]
                 [environ "1.1.0"]
                 [clj-time "0.14.2"]
                 [cljsjs/handsontable "0.31.2-0"]
                 [cljsjs/jquery "3.2.1-0"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-environ "1.1.0"]]
  :source-paths ["src/clj" "src/cljc"]
  :test-paths ["test/clj" "test/cljc"]
  :clean-targets ^{:protect false} [:target-path "resources/public/js"]
  :main jp.blackawa.examples.handsontable-cljs
  :profiles {:uberjar {:aot :all
                       :prep-tasks ["compile" ["cljsbuild" "once" "min"]]}
             :dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [com.stuartsierra/component.repl "0.2.0"]
                                  [figwheel-sidecar "0.5.15"]
                                  [com.cemerick/piggieback "0.2.2"]
                                  [org.clojure/tools.nrepl "0.2.10"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]
                                  :init-ns user}
                   :source-paths ["dev"]}}
  :cljsbuild {:builds [{:id "min"
                        :source-paths ["src/cljs" "src/cljc"]
                        :figwheel false
                        :compiler
                        {:main io.rooka.client
                         :asset-path "/js/out"
                         :output-to "resources/public/js/main.js"
                         :output-dir "resources/public/js/out"
                         :optimizations :advanced}}]})
