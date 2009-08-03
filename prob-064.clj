;;;;;;;;;; problem 064 ;;;;;;;;;;
(use '[clojure.contrib.math :only (sqrt)]
     '[clojure.set :only (difference)])

(defn cf-notation
  ([x] (cf-notation x 0 1 []))
  ([x n d coll]
     (let [m (.intValue (/ (+ (sqrt x) n) d))
           a (- n (* d m))]
       (cond
         (and (= d 1) (not= n 0)) (conj coll m)
         :else (recur x (* a -1) (quot (- x (* a a)) d) (conj coll m))))))

(defn sqr [n] (* n n))

(defn even-len? [c]
  (even? (count c)))

(defn prob-064 []
  (count
   (filter even-len?
           (map cf-notation
                (difference (set (range 2 10000)) (map sqr (range 2 100)))))))