(ns pages.list-page
  (:require [reagent.core :as r]))

(def input-value (r/atom ""))
(def list-data (r/atom []))

(defn handle-change [e]
  (swap! input-value #(.-target.value ^js e)))

(defn add-item [item]
  (swap! list-data conj {:name item :image nil}))

(defn handle-keydown [e]
  (let [key-code (.-keyCode e)]
    (when (= key-code 13)
      (add-item @input-value)
      (reset! input-value ""))))

(defn list-page []
  [:div "My List"
   [:input {:placeholder "Add Item" :class "pa2" :value @input-value :onChange handle-change :onKeyDown handle-keydown }]
   [:ul
    (for [list-item @list-data]
      [:li {:key (:name list-item)} (:name list-item)])]])
