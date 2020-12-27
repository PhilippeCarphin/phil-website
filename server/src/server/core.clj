(ns server.core
  (:require [org.httpkit.server :as s]
            [compojure.core :refer [routes POST GET ANY]]
            [compojure.route :as route]))
(use 'hiccup.core)
(defn app []
  (routes
    (GET "/resources/:file" [file] 
      {:status 200
      :body (slurp (str "resources/" file))})
    (GET "/clojure/:file" [file] 
      {:status 200
      :headers {"Content-Type" "text/html"}
      :body (load-file (str "clojure/" file))})
    (GET "/org/:file" [file]
      {:status 200
       :headers {"Content-Type" "text/html"}
       :body (slurp (str "org/" file))})
    ))

(defn create-server [] 
  (s/run-server (app) {:port 8081}))

(defn stop-server [server]
  (server :timeout 100))
