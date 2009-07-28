;;;;;;;;;; problem 030 ;;;;;;;;;;
(use '[clojure.contrib.math :only (expt)])

(defn fifth-powers? [n]
  (let [nums (map #(Integer. %) (rest (.split (str n) "")))]
    (= n (reduce + (map #(expt % 5) nums)))))

(defn prob-030 []
  (reduce + (for [n (range 2 1000000)
                  :when (fifth-powers? n)]
              n)))
