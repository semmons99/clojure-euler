;;;;;;;;;; problem 052 ;;;;;;;;;;
(defn digits [n]
  (map #(Integer. %) (rest (.split (str n) ""))))

(defn prob-052 []
  (first (for [x (iterate inc 1)
               :when (= (sort (digits x))
                        (sort (digits (* 2 x)))
                        (sort (digits (* 3 x)))
                        (sort (digits (* 4 x)))
                        (sort (digits (* 5 x)))
                        (sort (digits (* 6 x))))]
           x)))