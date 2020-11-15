(ns components.simple-card
  (:require ["@geist-ui/react" :as gui]))

(defn simple-card [title & children]
  [:> gui/Card {:hoverable true}
   [:h4 title]
   [:div children]
   #_[:> gui/Input {:size "large", :placeholder input-placeholder :onChange #(% (js/alert "hey you"))}]])
