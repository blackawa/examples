(defproject ring-atarxy-tryout "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-RC1"]
                 [ataraxy "0.4.0"]
                 [hiccup "1.0.5"]
                 [ring "1.6.3"]]
  :main ^:skip-aot ring-atarxy-tryout.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
