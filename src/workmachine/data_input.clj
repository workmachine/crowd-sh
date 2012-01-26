(ns workmachine.data-input
  (:use clj-html.core))

(defn image [name]
  {:name name
   :html (fn [value]
           [:img {:id name
                  :src value
                  :class "input-field"}])})

(defn audio [name]
  {:name name
   :html (fn [value]
           [:audio {:id name
                    :src value
                    :class "input-field"}])})

(defn text [name]
  {:name name
   :html (fn [value]
           [:span
            {:id name :class "input-field"}
            value])})

(defn instructions [name value]
  {:name name
   :html [:div {:id name :class "input-field"} value]})

(defn parse [field]
  (apply (case (first field)
           :instructions instructions
           :image image
           :text text
           :audio audio)
         (rest field)))
