(ns pages.home-page
  (:require ["@geist-ui/react" :as gui]
            [components.simple-card :refer [simple-card]]
            [components.top-menu :refer [top-menu]]))

(defn create-new-list [e]
  (println "test")
  (js/console.log e))

(defn home-page []
  [:> gui/Page
   [:> gui/Page.Header
    [top-menu]]
   [:> gui/Page.Content
    [:> gui/Grid.Container {:gap 2 :justify "center"}
     [:> gui/Grid {:xs 12}
      [simple-card "Create a new list"
       [:> gui/Input {:type "text" :placeholder "new list" :onChange create-new-list}]]]
     [:> gui/Grid {:xs 12}
      [simple-card "View an existing list"
       [:> gui/Input {:type "text" :placeholder "ID"}]]]
     [:> gui/Grid {:xs 24}
      [:> gui/Button "Go"]]]]])
