(defproject monolith "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 ;; clojure itself
                 [org.clojure/clojure "1.9.0"]
                 [org.clojure/core.async "0.4.474"]
                 [org.clojure/clojurescript "1.10.238"]
                 ;; component
                 [integrant "0.6.3"]
                 [aero "1.1.3"]
                 ;; ring
                 [ring "1.6.3"]
                 [ring/ring-defaults "0.3.1"]
                 [metosin/muuntaja "0.5.0"]
                 ;; jdbc
                 [duct/database.sql.hikaricp "0.3.3"]
                 [duct/migrator.ragtime "0.2.2"]
                 [honeysql "0.9.2"]
                 [org.clojure/java.jdbc "0.7.5"]
                 [org.postgresql/postgresql "42.1.4"]
                 ;; others
                 [bidi "2.1.3"]
                 [bouncer "1.0.1"]
                 [buddy "2.0.0"]
                 [clj-http "3.8.0"]
                 [cljs-http "0.1.45"]
                 [com.taoensso/timbre "4.10.0"]
                 [com.cemerick/url "0.1.1"]
                 [rum "0.11.2"]
                 [venantius/accountant "0.2.4"
                  :exclusions [org.clojure/tools.reader]]]
  :plugins [[lein-cljsbuild "1.1.7"]]
  :source-paths ["src/clj" "src/cljc"]
  :test-paths ["test/clj" "test/cljc"]
  :clean-targets ^{:protect false} [:target-path "resources/public/js"]
  :main monolith.core
  :uberjar-name "monolith.jar"
  :profiles {:uberjar {:aot :all
                       :prep-tasks ["compile" ["cljsbuild" "once" "min"]]}
             :dev {:dependencies [[integrant/repl "0.3.1"]]
                   :source-paths ["dev/src" "src/clj" "src/cljc"]
                   :repl-options {:init-ns user}}}
  :cljsbuild {:builds [{:id "min"
                        :source-paths ["src/cljs" "src/cljc"]
                        :figwheel false
                        :compiler
                        {:main monolith.client
                         :asset-path "/js/out"
                         :output-to "resources/public/js/main.js"
                         :output-dir "resources/public/js/out"
                         :optimizations :advanced}}]})
