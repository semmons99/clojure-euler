;;;;;;;;;; problem 063 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])

(defn digits [n]
  (count (rest (.split (str n) ""))))

(defn prob-063 []
  (count
   (for [pow (range 1 25)
         n (map #(expt % pow) (iterate inc 1))
         :let [cnt (digits n)]
         :while (<= cnt pow)
         :when  (= cnt pow)]
     n)))