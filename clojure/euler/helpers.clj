(ns clojure.euler.helpers
  (:use [clojure.contrib.def :only (defvar)]))

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
(def prime? (memoize prime?))

(defn nth-triangle [n] (/ (* n (inc n)) 2))
(defvar triangles (map nth-triangle (iterate inc 1)))
(defn triangle? [n] (some #(= % n) (take-while #(<= % n) triangles)))

(defn nth-square [n] (* n n))
(defvar squares (map nth-square (iterate inc 1)))
(defn square? [n] (some #(= % n) (take-while #(<= % n) squares)))

(defn nth-pentagonal [n] (/ (* n (dec (* 3 n))) 2))
(defvar pentagonals (map nth-pentagonal (iterate inc 1)))
(defn pentagonal? [n] (some #(= % n) (take-while #(<= % n) pentagonals)))

(defn nth-hexagonal [n] (* n (dec (* 2 n))))
(defvar hexagonals (map nth-hexagonal (iterate inc 1)))
(defn hexagonal? [n] (some #(= % n) (take-while #(<= % n) hexagonals)))

(defn nth-heptagonal [n] (/ (* n (- (* 5 n) 3)) 2))
(defvar heptagonals (map nth-heptagonal (iterate inc 1)))
(defn heptagonal? [n] (some #(= % n) (take-while #(<= % n) heptagonals)))

(defn nth-octagonal [n] (* n (- (* 3 n) 2)))
(defvar octagonals (map nth-octagonal (iterate inc 1)))
(defn octagonal? [n] (some #(= % n) (take-while #(<= % n) octagonals)))