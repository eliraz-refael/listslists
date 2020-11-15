(ns components.layout
  (:require ["@geist-ui/react" :as gui]))

(defn main-layout [& children]
  [:> gui/GeistProvider
   [:> gui/CssBaseline]
   [:div "I'm the layout!"]
   [children]])
