(ns koans.21-group-by
  (:require [koan-engine.core :refer :all]))

(defn get-odds-and-evens [coll]
  (let [{odds true evens false} (group-by __ coll)]
    [odds evens]))

(meditations

  ;; "To categorize a collection by some function, use group-by."
  "컬렉션을 어떤 함수로 분류하려면 group-by를 쓰라"
  (= __ (group-by count ["hello" "world" "foo" "bar"]))


  ;; "You can simulate filter + remove in one pass"
  "filter와 remove를 한꺼번에 할 수 있다"
  (= (get-odds-and-evens [1 2 3 4 5])
     ((juxt filter remove) odd? [1 2 3 4 5])
     [[1 3 5] [2 4]])

  ;; "You can also group by a primary key"
  "기본 키(primary key) 기준으로 그룹을 나눌 수도 있다"
  (= __
     (group-by :id [{:id 1 :name "Bob"}
                    {:id 2 :name "Mike"}
                    {:id 1 :last-name "Smith"} ]))

  ;; "But be careful when you group by non-required key"
  "그러나 선택 키(non-required key)로 그룹을 나눌 때는 조심하라"
  (= {"Bob" [{:name "Bob" :id 1}]
      "Mike" [{:name "Mike" :id 2}]
      __ [{:last-name "Smith" :id 1}]}
   (group-by :name [{:id 1 :name "Bob"}
                    {:id 2 :name "Mike"}
                    {:id 1 :last-name "Smith"}]))

  ;; "The true power of group-by comes with custom functions"
  "group-by의 진짜 힘은 맞춤(custom) 함수와 함께 나온다"
  (= __
     (group-by #(if (:bad %) :naughty-list :nice-list)
               [{:name "Jimmy" :bad true}
                {:name "Jack" :bad false}
                {:name "Joe" :bad true}])))
