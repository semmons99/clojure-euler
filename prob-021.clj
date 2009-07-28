;;;;;;;;;; problem 021 ;;;;;;;;;;
(use '[clojure.contrib.math :only (sqrt)])

(defn dn [n]
  (inc (reduce + (for [x (range 2 (sqrt n))
                       :when (zero? (mod n x))]
                   (+ x (/ n x))))))

(defn prob-021 []
  (reduce + (for [a (range 1 10000)
                  :let [b (dn a)]
                  :when (and (not= a b)
                             (= (dn b) a))]
              a)))
