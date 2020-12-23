(ns server.core
  (:require [org.httpkit.server :as s]
            [compojure.core :refer [routes POST GET ANY]]
            [compojure.route :as route]))
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
                  [:p "This is a <p> tag in that h2 section"]]])})
    (GET "/other" [:as req]
      {:status 200
      :headers {"Content-Type", "text/html"}
      :body (html
              [:html
                [:head [:title "Other Route"]]
                [:body
                  [:h1 "Other ROUTE!"]]])})
    (GET "/extern" [:as req]
      {:status 200
      :headers {"Content-Type", "text/html"}
      :body (load-file "src/server/today.clj")}
      )
    (GET "/sidebar" [:as req]
      {:status 200
      :headers {"Content-Type", "text/html"}
      :body (load-file "src/server/sidebar.clj")}
      )
    (GET "/src/server/style.css" [:as req]
      {:status 200
      :headers {"Content-Type", "text/css"}
      :body (slurp "src/server/style.css")})

    (GET "/normal" [:as req]
      {:status 200
      :headers {"Content-Type", "text/html"}
      :body (slurp "src/server/normal.html")}
      )
    (GET "/resources/:file" [file] 
      {:status 200
      :body (slurp (str "resources/" file))})
      
      ))

(defn get-file [file] 
  ())

(defn create-server [] 
  (s/run-server (app) {:port 8081}))

(defn stop-server [server]
  (server :timeout 100))
