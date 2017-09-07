(comment defn pangram [input costs]
  (let [input-set (into #{} input)
        cost-map  (into {} (map #(vector %1 %2) "abcdefghigklmnopqrstuvwxyz" costs))]
    (reduce (fn [cost ch]
              (if-not (contains? input-set ch)
                (+ cost (get cost-map ch))
                cost))
            0
            "abcdefghigklmnopqrstuvwxyz")))

(defn pangram [input costs]
  (let [presence-report (reduce (fn [acc ch] 
                                  (update acc ch #(inc (or % 0)))) 
                                {}
                                input)]
    (reduce (fn [result ch]
              (if-not (get presence-report ch)
                (+ result (nth costs (- (int ch) (int \a))))
                result))
            0
            "abcdefghigklmnopqrstuvwxyz")))

(comment (pangram "abcdefghijklmopqrstuvwz" 
                  [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26]))

(comment 
  (pangram "thequickbrownfoxjumpsoverthelazydog" 
           [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26]))

(let [test-cases-count (Integer/parseInt (read-line))]
  (when (and (> test-cases-count 0) (< test-cases-count 50))
    (dotimes [i test-cases-count]
      (let [nums-temp (-> (read-line) 
                          (clojure.string/split #"\s+"))
            nums (map #(Integer/parseInt %) nums-temp)
            text (read-line)]
        (when (> (count text) 50000) 
            (println (pangram text nums)))))))
