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

(defn reload-mount []
  (js/console.log "RELOADING AGAIN!")
  (rd/render [router-page {:x (js/Date.now)}] (. js/document getElementById "app") functional-compiler))

(defn init-start []
  (js/console.log "Starting...")
  (.appendChild js/document.body (doto (.createElement js/document "div")
                                   (-> (.setAttribute "id" "app"))))
  (mount))

(defn ^:export init []
  (rfe/start!
    (rf/router routes {:data {:coercion rss/coercion}})
    (fn [m] (reset! match m))
    {:use-fragment false})
  (init-start))

(defn ^:dev/after-load start []
  (swap! app.router/match assoc :dummy (.now js/Date))
  (mount))

(defn ^:export reload! []
  (mount))
