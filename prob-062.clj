;;;;;;;;;; problem 062 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)]
     '[clojure.contrib.def :only (defvar)]
     '[clojure.contrib.seq-utils :only (frequencies)])

(defn cube [n]
  (expt n 3))

(defvar cubes
  (map cube (iterate inc 1)))

(defn prob-062 []
  (let [cs (zipmap (iterate inc 1)
                   (map #(sort (str %)) (take 10000 cubes)))
        five_cs (filter #(= 5 (last %)) (frequencies (vals cs)))]
    (cube (reduce min (keys (filter #(= (val %) (ffirst five_cs)) cs))))))