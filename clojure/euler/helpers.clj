(ns clojure.euler.helpers)

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
