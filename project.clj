(defproject balance "0.1.0-SNAPSHOT"
  :description "Application for tracking your time through the day"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [seesaw "1.4.2"]
                 [com.github.insubstantial/substance "7.1"]]
;  :jvm-opts ["-Dswing.defaultlaf=org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel"]
  :main balance.devel)
