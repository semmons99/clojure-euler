;;;;;;;;;; problem 065 ;;;;;;;;;;
(use '[clojure.contrib.def :only (defvar)]
     '[clojure.contrib.seq-utils :only (flatten)])

(defvar cf-e
  (concat [2] (flatten (concat (for [n (iterate inc 1)]
                [1 (* 2 n) 1])))))

(defn conv [coll]
  (loop [n (last coll), c (butlast coll)]
    (if (empty? c)
      n
      (recur (+ (last c) (/ 1 n)) (butlast c)))))

(defn get-num [r]
  (first (.split (str r) "/")))

(defn sum-digits [s]
  (reduce + (map #(Integer. %) (rest (.split s "")))))

(defn prob-065 []
  (sum-digits (get-num (conv (take 100 cf-e)))))