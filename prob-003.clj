;;;;;;;;;; problem 003 ;;;;;;;;;;
(use '[clojure.contrib.math :only (sqrt)])

(defn prime? [n]
  (cond
    (< n 2) false
    (< n 4) true
    (even? n) false
    :else (let [lim (inc (Math/sqrt n))]
            (loop [x 3]
              (cond
                (> x lim) true
                (zero? (mod n x)) false
                :else (recur (inc x)))))))

(defn prob-003 []
  (let [num 600851475143]
    (last (filter #(and (zero? (mod num %)) (prime? %))
                  (range 1 (+ 1 (sqrt num)))))))