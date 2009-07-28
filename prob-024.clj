;;;;;;;;;; problem 024 ;;;;;;;;;;
(use '[clojure.contrib.combinatorics :only (lex-permutations)])

(defn prob-024 []
  (reduce str (nth (lex-permutations (range 10)) 999999)))
