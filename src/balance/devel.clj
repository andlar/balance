(ns balance.devel
  (:require [balance.view :as view]
            [seesaw.core :as sc]
            ))

(defn show-gui []
  (sc/show! view/main-window))
