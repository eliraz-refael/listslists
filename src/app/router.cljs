(ns app.router
  (:require [pages.home-page :refer [home-page]]
            [reagent.core :as r]
            ["@geist-ui/react" :as gui]))

(defn test-page []
  [:div "this is my test page"])

(def routes
  [["/"
    {:name ::frontpage
     :view home-page}]
   ["/test" {:name ::testpage :view test-page}]])

(defonce match (r/atom nil))

(defn router-page []
  [:> gui/GeistProvider
   [:> gui/CssBaseline]
   (if @match
     (let [view (:view (:data @match))]
       [view @match]))])
