(ns koans.15-refs
  (:require [koan-engine.core :refer :all]))

(def the-world (ref "hello"))
(def bizarro-world (ref {}))

(meditations
  ;; "In the beginning, there was a word"
  "태초에 말씀이 있었다"
  (= __ (deref the-world))

  ;; "You can get the word more succinctly, but it's the same"
  "더 간결히 쓸 수 있지만, 결국 같은 것이다"
  (= __ @the-world)

  ;; "You can be the change you wish to see in the world."
  "네가 세상에서 보기 원하는 변화, 네가 스스로 그 변화가 될 수 있다"
  (= __ (do
          (dosync (ref-set the-world "better"))
          @the-world))

  ;; "Alter where you need not replace"
  "기존 값을 바탕으로 변경할 수 있다"
  (= __ (let [exclamator (fn [x] (str x "!"))]
          (dosync
           (alter the-world exclamator)
           (alter the-world exclamator)
           (alter the-world exclamator))
          @the-world))

  ;; "Don't forget to do your work in a transaction!"
  "트랜잭션 안에서 처리해야 하는 점을 잊지 마라"
  (= 0 (do __
           @the-world))

  ;; "Functions passed to alter may depend on the data in the ref"
  "alter에 전달하는 함수는 ref에 담긴 데이터에 의존한다"
  (= 20 (do
          (dosync (alter the-world ___))))

  ;; "Two worlds are better than one"
  "두 세상이 하나보다 낫다"
  (= ["Real Jerry" "Bizarro Jerry"]
       (do
         (dosync
          (ref-set the-world {})
          (alter the-world assoc :jerry "Real Jerry")
          (alter bizarro-world assoc :jerry "Bizarro Jerry")
          __))))
