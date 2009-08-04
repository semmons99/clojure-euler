;;;;;;;;;; problem 066 ;;;;;;;;;;
; uses pell's equation
(use '[clojure.contrib.math :only (sqrt)]
     '[clojure.contrib.def :only (defvar)]
     '[clojure.contrib.seq-utils :only (flatten)])

(defn sqr [n] (* n n))

(defn conv [coll]
  (loop [n (last coll), c (butlast coll)]
    (if (empty? c)
      n
      (recur (+ (last c) (/ 1 n)) (butlast c)))))

(defn cf-notation
  ([x] (cf-notation x 0 1 []))
  ([x n d coll]
     (let [m (.intValue (/ (+ (sqrt x) n) d))
           a (- n (* d m))]
       (cond
         (and (= d 1) (not= n 0)) (conj coll m)
         :else (recur x (* a -1) (quot (- x (sqr a)) d) (conj coll m))))))

(defn lazy-cf [n]
  (let [cf (cf-notation n)]
    (flatten (cons (first cf) (repeat (rest cf))))))

(defn numerator [r]
  (bigint (first (.split (str r) "/"))))

(defn denominator [r]
  (let [d (second (.split (str r) "/"))]
    (if (nil? d) 1 (bigint d))))

(defn find-min [n]
  (first
   (for [i (iterate inc 1)
         :let [cv (conv (take i (lazy-cf n)))
               x (numerator cv)
               y (denominator cv)]
         :when (= 1 (- (sqr x) (* n (sqr y))))]
     [n x y])))

(defn sqr? [n]
  (let [x (sqrt n)]
    (= x (.intValue x))))

(defn not-sqr? [n] (not (sqr? n)))

(defvar non-sqrs
  (filter not-sqr? (iterate inc 2)))

(defn biggest-val [a b]
  (if (> (second a) (second b)) a b))

(defn prob-066 []
  (first
   (reduce biggest-val
           (map find-min (take-while #(<= % 1000) non-sqrs)))))