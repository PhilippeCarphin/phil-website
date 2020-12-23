(ns server.core
  (:require [org.httpkit.server :as s]
            [compojure.core :refer [routes POST GET ANY]]))
(use 'hiccup.core)
(defn app []
  (routes
    (GET "/" [:as req]
      {:status 200
      :headers {"Content-Type" "text/html"}
      :body (html
              [:html
                [:head [:title "Hiccup test"]]
                [:body 
                  [:h1 "This is an h1"]
                  [:p "I like how this permits me to express HTML as a Clojure data structure.
                  Indeed, doing this was easier than I thought and I thing I might like writing simple
                  HTML like this."]
                  [:p "This is a second paragraph"]
                  [:h2 "This is an h2"]
                  [:p "This is a <p> tag in that h2 section"]]])})))

(defn create-server [] 
  (s/run-server (app) {:port 8081}))

(defn stop-server [server]
  (server :timeout 100))
