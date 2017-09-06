(defn my-reduce
  ([reducer seq-able]
   (my-reduce reducer (rest seq-able) (first seq-able)))
  ([reducer seq-able acc]
   (if (seq seq-able)
     (my-reduce reducer 
                (rest seq-able)
                (reducer acc (first seq-able)))
     acc)))

(= (my-reduce + [1 2 3 4 5] 0)
   (reduce + 0  [1 2 3 4 5]))

(= (my-reduce * (list 2 2 2))
   (reduce * (list 2 2 2)))
