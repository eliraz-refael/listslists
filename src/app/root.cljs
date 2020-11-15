(ns app.root
  (:require ["@geist-ui/react" :as gui]
            [app.app :refer [app]]))

(defn root []
  [:> gui/GeistProvider
      [:> gui/CssBaseline
          [app]]])
