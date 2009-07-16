;;;;;;;;;; problem 043 ;;;;;;;;;;
(use '[clojure.contrib.combinatorics :only (permutations)])

(defn interesting? [n]
  (loop [a (rest (partition 3 1 n)), b [2 3 5 7 11 13 17]]
    (cond
      (empty? a) true
      (not (zero? (mod (Integer. (apply str (first a))) (first b)))) false
      :else (recur (rest a) (rest b)))))

(defn prob-043 []
  (reduce + (map #(bigint (apply str %))
                 (filter interesting? (permutations (range 10))))))