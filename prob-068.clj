;;;;;;;;;; problem 068 ;;;;;;;;;;
(use '[clojure.contrib.combinatorics :only (selections)]
     '[clojure.set :only (difference)])

(defn sets-for [ns es]
  (let [ds (apply difference (cons ns es))]
    (cond
      (empty? ds) []
      (= 1 (count ds))
      (let [e [(first ds) (last (last es)) (second (first es))]]
        (if (= (reduce + e) (reduce + (last es)))
          [e]
          []))
      :else
      (for [xs (selections ds 2)
            :when (= 2 (count (distinct xs)))
            :let [e [(first xs) (last (last es)) (last xs)]]
            :when (= (reduce + e) (reduce + (last es)))]
        e))))

(defn gon-solutions []
  (let [ns #{1 2 3 4 5 6 7 8 9 10}]
    (distinct
     (for [e1 (map vec (selections ns 3))
           :when (= 3 (count (distinct e1)))
           e2 (sets-for ns [e1])
           e3 (sets-for ns [e1 e2])
           e4 (sets-for ns [e1 e2 e3])
           e5 (sets-for ns [e1 e2 e3 e4])
           :when (and (< (first e1) (first e2))
                      (< (first e1) (first e3))
                      (< (first e1) (first e4))
                      (< (first e1) (first e5)))]
       [e1 e2 e3 e4 e5]))))

(defn prob-068 []
  (apply str (apply concat (last (gon-solutions)))))