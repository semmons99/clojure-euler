;;;;;;;;;; problem 046 ;;;;;;;;;;
(use '[clojure.euler.helpers :only (prime?)])

(defn composites [] (filter #(not (prime? %)) (iterate inc 3)))

(defn odd-composites [] (filter odd? (composites)))

(defn conjecture-valid? [n]
  (some prime? (take-while #(> % 0) (map #(- n (* 2 % %)) (iterate inc 1)))))

(defn prob-046 []
  (first (filter #(not (conjecture-valid? %)) (odd-composites))))