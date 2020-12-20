(ns server.core
  (:require [org.httpkit.server :as s]))

(defn handler [req]
  {:status 200
  :header {"Content-Type" "text/html"}
  :body "<h1>HELLO WORLD</h1>"})

(defn create-server [] 
  (s/run-server handler {:port 8080}))

(defn stop-server [server]
  (server :timeout 100))
