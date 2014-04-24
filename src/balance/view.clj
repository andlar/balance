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

;;Styling
(def primary-style
  (sg/style :foreground (scolor/color :black)
            :background (scolor/color :green)))
(def other-style
  (sg/style :foreground (scolor/color :black)
            :background (scolor/color :blue)))
(def commute-style
  (sg/style :foreground (scolor/color :black)
            :background (scolor/color :orange)))
(def fun-style
  (sg/style :foreground (scolor/color :black)
            :background (scolor/color :yellow)))
(def exercise-style
  (sg/style :foreground (scolor/color :black)
            :background (scolor/color :purple)))
(def sleep-style
  (sg/style :foreground (scolor/color :black)))

;;forward declaration
(def main-window)

;; canvases
(def time-selector
  (sc/horizontal-panel
   :items (map (partial sc/button :text)
               ["Primary Work" "Other Work" "Commute"
                "Fun & Relaxing" "Exercise & Life Maintenance"
                "Sleep"])))

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
