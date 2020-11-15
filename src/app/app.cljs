(ns app.app
  (:require
            [pages.home-page :refer [home-page]]))

(defn app []
  [home-page])
