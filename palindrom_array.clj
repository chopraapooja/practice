(defn palindrome? [items]
  "Efficient algorithm: loops through only (array-size/2)"
  (loop [i 0
         j (-> items count dec)]
    (cond (>= i j)
          true
          (not= (nth items i) 
                (nth items j))
          false
          :else
          (recur (inc i) (dec j)))))

(let [test-cases-count (Integer/parseInt (read-line))
      test-cases       (for [i (range test-cases-count)]
                         (let [nums-count (read-line)
                               nums-temp (-> (read-line) (clojure.string/split #"\s+"))
                               nums (map #(Integer/parseInt %) nums-temp)]
                           nums))]
  (for [t test-cases]
    (if (palindrome? t)
      (println "Yes")
      (println "No"))))
