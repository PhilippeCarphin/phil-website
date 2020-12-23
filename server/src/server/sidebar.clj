(use 'hiccup.core)
; from https://www.w3schools.com/howto/howto_css_sidebar_responsive.asp
(html
  [:html
    [:head 
      [:title "TODAY"]
      [:link {:rel "stylesheet" :href "src/server/style.css"}]]
    [:body 
      [:div {:class "sidebar"}
        [:a {:class "active" :href "#home"} "Home"]
        [:a {:href "#news"} "News"]
        [:a {:href "#contact"} "Contact"]
        [:a {:href "#about"} "About"]]
      [:div {:class "content"} "CONTENT"]

      ]])