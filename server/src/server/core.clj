(ns server.core
  (:require [org.httpkit.server :as s]
            [compojure.core :refer [routes POST GET ANY]]))

(defn app []
  (routes
    (GET "/" [:as req]
      {:status 200
      :header {"Content-Type" "text/html"}
      :body "<h1>HELLO WORLD APP</h1>"})))

(defn handler [req]
  {:status 200
  :header {"Content-Type" "text/html"}
  :body "<h1>HELLO WORLD</h1>"})

(defn create-server [] 
  (s/run-server (app) {:port 8080}))

(defn stop-server [server]
  (server :timeout 100))
