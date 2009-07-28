;;;;;;;;;; problem 061 ;;;;;;;;;;
(use '[clojure.euler.helpers :only (triangle? square? pentagonal? hexagonal?
                                              heptagonal? octagonal?)])

(defn from-cyclical [n]
  (Integer. (str (subs (str n) 2) "00")))

(defn to-cyclical [n]
  (inc (Integer. (str (subs (str n) 2) "99"))))

(defn to-type [n]
  (filter #(not (nil? %)) [(when (triangle? n) :triangle)
                           (when (square? n) :square)
                           (when (pentagonal? n) :pentagonal)
                           (when (hexagonal? n) :hexagonal)
                           (when (heptagonal? n) :heptagonal)
                           (when (octagonal? n) :octagonal)]))

(defn valid-coll? [c]
  (= (count c) (count (set c))))

(defn prob-061 []
  (reduce + (first
             (for [a (range 1000 10000)
                   :let [at (to-type a)]
                   :when (and (not-empty at) (valid-coll? [at]))
                   :let [from (from-cyclical a) to (to-cyclical a)]
                   :when (> from 999)
                   b (range from to)
                   :let [bt (to-type b)]
                   :when (and (not-empty bt) (valid-coll? [at bt]))
                   :let [from (from-cyclical b) to (to-cyclical b)]
                   :when (> from 999)
                   c (range from to)
                   :let [ct (to-type c)]
                   :when (and (not-empty ct) (valid-coll? [at bt ct]))
                   :let [from (from-cyclical c) to (to-cyclical c)]
                   :when (> from 999)
                   d (range from to)
                   :let [dt (to-type d)]
                   :when (and (not-empty dt) (valid-coll? [at bt ct dt]))
                   :let [from (from-cyclical d) to (to-cyclical d)]
                   :when (> from 999)
                   e (range from to)
                   :let [et (to-type e)]
                   :when (and (not-empty et) (valid-coll? [at bt ct dt et]))
                   :let [from (from-cyclical e) to (to-cyclical e)]
                   :when (> from 999)
                   f (range from to)
                   :let [ft (to-type f)]
                   :when (and (not-empty ft) (valid-coll? [at bt ct dt et ft]))
                   :let [from (from-cyclical f) to (to-cyclical f)]
                   :when (<= from a to)]
               [a b c d e f]))))
