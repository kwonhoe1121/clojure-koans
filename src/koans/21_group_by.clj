(ns koans.21-group-by
  (:require [koan-engine.core :refer :all]))

(defn get-odds-and-evens [coll]
  (let [{odds true evens false} (group-by #(odd? %) coll)]
    [odds evens]))

(meditations

  "컬렉션을 어떤 함수로 분류하려면 group-by를 쓰라"
  (= {5 ["hello" "world"] 3 ["foo" "bar"]} (group-by count ["hello" "world" "foo" "bar"]))


  "filter와 remove를 한꺼번에 할 수 있다"
  (= (get-odds-and-evens [1 2 3 4 5])
     ((juxt filter remove) odd? [1 2 3 4 5])
     [[1 3 5] [2 4]])

  "기본 키(primary key) 기준으로 그룹을 나눌 수도 있다"
  (= {1 [{:id 1 :name "Bob"} {:id 1 :last-name "Smith"}] 2 [{:id 2 :name "Mike"}]}
     (group-by :id [{:id 1 :name "Bob"}
                    {:id 2 :name "Mike"}
                    {:id 1 :last-name "Smith"} ]))

  "그러나 선택 키(non-required key)로 그룹을 나눌 때는 조심하라"
  (= {"Bob" [{:name "Bob" :id 1}]
      "Mike" [{:name "Mike" :id 2}]
      nil [{:last-name "Smith" :id 1}]}
   (group-by :name [{:id 1 :name "Bob"}
                    {:id 2 :name "Mike"}
                    {:id 1 :last-name "Smith"}]))

  "group-by의 진짜 힘은 맞춤(custom) 함수와 함께 나온다"
  (= {:naughty-list [{:name "Jimmy" :bad true} {:name "Joe" :bad true}] :nice-list [{:name "Jack" :bad false}]}
     (group-by #(if (:bad %) :naughty-list :nice-list)
               [{:name "Jimmy" :bad true}
                {:name "Jack" :bad false}
                {:name "Joe" :bad true}])))
