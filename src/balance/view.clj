(ns balance.view
  (:require [seesaw.core :as sc]
            [seesaw.graphics :as sg]
            [seesaw.color :as scolor]
            [seesaw.table :as st])
  (:import org.pushingpixels.substance.api.SubstanceLookAndFeel)
  (:gen-class))

;;Config
(def title "Balance")
(def window-size {:width 800
                  :height 400})

(defn dec-string-cmp [s1 s2]
  (* -1 (compare s1 s2)))

;; sample data
(def data (sorted-map-by dec-string-cmp
                         "2014-05-06" [:sleep :sleep :sleep :sleep :sleep :sleep :life :commute :primary :other :other :other :other :exercise :other :primary :commute :fun :fun :exercise :fun :fun :fun :sleep :sleep]
                         "2014-05-05" [:sleep :sleep :sleep :sleep :sleep :sleep :life :life :primary :other :other :other :other :fun :other :primary :fun :fun :fun :exercise :fun :fun :fun :sleep :sleep]
                         "2014-05-03" [:sleep :sleep :sleep :sleep :sleep :sleep :life :commute :primary :other :other :other :other :exercise :other :primary :commute :fun :fun :exercise :fun :fun :fun :sleep :sleep]
                         "2014-05-08" [:sleep :sleep :sleep :sleep :sleep :sleep :life :commute :commute :other :other :other :primary :primary :primary :primary :primary :commute :none :none :none :none :none :none]
                         "2014-05-04" [:sleep :sleep :sleep :sleep :sleep :sleep :life :life :primary :other :other :other :other :fun :other :primary :fun :fun :fun :exercise :fun :fun :fun :sleep :sleep]))

;; actions definition
(def actions {:primary  {:text "Primary Work"
                         :style (sg/style :foreground (scolor/color :green)
                                          :background (scolor/color :green))}
              :other    {:text "Other Work"
                         :style (sg/style :foreground (scolor/color :blue)
                                          :background (scolor/color :blue))}
              :commute  {:text "Commute"
                         :style (sg/style :foreground (scolor/color :orange)
                                          :background (scolor/color :orange))}
              :fun      {:text "Fun & Relaxing"
                         :style (sg/style :foreground (scolor/color :yellow)
                                          :background (scolor/color :yellow))}
              :life     {:text "Life Maintenance"
                         :style (sg/style :foreground (scolor/color :lightblue)
                                          :background (scolor/color :lightblue))}
              :exercise {:text "Exercise"
                         :style (sg/style :foreground (scolor/color :purple)
                                          :background (scolor/color :purple))}
              :sleep    {:text "Sleep"
                         :style (sg/style :foreground (scolor/color :darkgray)
                                          :background (scolor/color :darkgray))}
              :none     {:text "Nothing"
                         :style (sg/style :foreground (scolor/color :white))}})

;;forward declaration
(def main-window)
(def action-bg (sc/button-group))

;; create button
(defn make-action-selector [action-dsc]
  (sc/radio :id (str (key action-dsc) "-radio")
             :text (:text (val action-dsc))
             :group action-bg))

;; canvases
(def time-selector
  (sc/horizontal-panel
   :items (map make-action-selector actions)))

(def time-canvas
  (sc/canvas :id :timecanvas
             :background :white))

;;panels
(def time-panel
  (sc/grid-panel :items [time-canvas]))

;;content
(def window-content
  (sc/border-panel
   :north time-selector
   :center time-panel))

(def main-window
  (sc/frame :title title
            :width (:width window-size)
            :height (:height window-size)
            :content window-content))

;;painting time
(defn render-day [row col action]
  (let [box-width (/ (sc/width main-window) 24)
        box-height 20]
    [(sg/rect (* box-width col) (* box-height row) box-width box-height)
     (:style (action actions))]))

(defn render-time []
  (apply concat
         (map-indexed
          (fn [z-index rowdata] (map-indexed (partial render-day z-index) rowdata))
          (vals data))))

(defn paint-time [context graphics]
  (apply sg/draw graphics
         (apply concat (render-time))))

(defn repaint []
  (sc/repaint! time-canvas))

;;init
(defn init-view []
  (sc/config! time-canvas :paint paint-time))


;; data entry stuff; does this belong here?
(defn- create-action [_ newaction]
  (keyword newaction))

(defn- update-action [date position action]
  (update-in data [date position] create-action action))

(defn update-action! [date position action]
  (def data (update-action date position action))
  (repaint))
