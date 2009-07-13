;;;;;;;;;; problem 034 ;;;;;;;;;;
(defn factorial [n]
  (reduce * (range 1 (inc n))))
(def factorial (memoize factorial))

(defn sum-of-factorial? [n]
  (= n (reduce + (map #(factorial (Integer. %)) (rest (.split (str n) ""))))))

(defn prob-034 []
  (reduce + (for [n (range 10 100000)
                  :when (sum-of-factorial? n)]
              n)))