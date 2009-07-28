;;;;;;;;;; problem 012 ;;;;;;;;;;
(use '[clojure.contrib.math :only (sqrt)])

(defn triangles []
  (map #(reduce + (range %)) (iterate inc 2)))

(defn factors [n]
  (reduce into (for [x (range 1 (inc (sqrt n)))
                     :when (zero? (mod n x))]
                 [x (/ n x)])))

(defn prob-012 []
  (first (filter #(< 500 (count (factors %))) (triangles))))
