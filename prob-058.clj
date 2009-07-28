;;;;;;;;;; problem 058 ;;;;;;;;;;
(use '[clojure.euler.helpers :only (prime?)])

(defn next-spiral [entry]
  (let [sides (+ (entry :sides) 2)
        corners (+ (entry :corners) 4)
        c1 (* sides sides)
        c2 (inc (- c1 sides))
        c3 (inc (- c2 sides))
        c4 (inc (- c3 sides))
        primes (into (filter prime? [c1 c2 c3 c4])
                     (entry :primes))
        ratio (prime-ratio primes corners)]
    {:sides sides :corners corners :primes primes :ratio ratio}))

(defn prime-ratio [primes corners]
  (/ (count primes) corners))

(defn prob-058 []
  (:sides (first
           (filter #(< (% :ratio) 0.1)
                   (iterate next-spiral {:sides 3
                                         :corners 5
                                         :primes [7 5 3]
                                         :ratio (/ 3 5)})))))
