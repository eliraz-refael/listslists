(ns app.main
  (:require [reagent.dom :as rd]
            [reagent.core :as r]
            [reitit.frontend.easy :as rfe]
            [reitit.frontend :as rf]
            [reitit.coercion.spec :as rss]
            [app.router :refer [router-page match routes]]))

(def functional-compiler (r/create-compiler {:function-components true}))

(defn mount []
 (rd/render [router-page] (. js/document getElementById "app") functional-compiler))

(defn start []
  (js/console.log "Starting...")
  (.appendChild js/document.body (doto (.createElement js/document "div")
                                   (-> (.setAttribute "id" "app"))))
  (mount))

(defn ^:export init []
  (rfe/start!
    (rf/router routes {:data {:coercion rss/coercion}})
    (fn [m] (reset! match m))
    {:use-fragment false})
  (start))

(defn ^:export reload! []
  (mount))
