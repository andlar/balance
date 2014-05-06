(ns balance.devel
  (:require [balance.view :as view]
            [seesaw.core :as sc])
  (:import org.pushingpixels.substance.api.SubstanceLookAndFeel))

(defn show-gui []
  (view/init-view)
  (sc/show! view/main-window)
  (sc/native!)
  (SubstanceLookAndFeel/setSkin (.getClassName (get (SubstanceLookAndFeel/getAllSkins) "Sahara"))))
