
(use 'hiccup.core)
(html
  [:html
    [:head [:title "TODAY"]]
    [:body 
      [:h1 "This is an h1 from TODAY!!!"]
      [:p "This is very cool!  Doing (load-file <this-file>) 'returns' or evaluates to this expression
      so this file doesn't need to define a function that some code has to call.  Just this load-file call."]
      [:h2 "Blog posts like this"]
      [:p "Maybe I could write a blog post as some clojure file.  Anyway, it can be one or the other"]
      [:p "If I want to write some HTML, I can do that, and if I want to do something else, I can do something else"]
      ]])
