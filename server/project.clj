(defproject server "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [http-kit "2.8.0"]
                 [compojure "1.6.0"]
                 [hiccup "1.0.5"]]
  :repl-options {:init-ns server.core
                 :prompt (fn [ns]
                         (str "\033[1;32m"
                              ns "=>"
                              "\033[0m "))}
  :main server.core
  )
