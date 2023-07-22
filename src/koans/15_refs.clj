(ns koans.15-refs
  (:require [koan-engine.core :refer :all]))

(def the-world (ref "hello"))
(def bizarro-world (ref {}))

(meditations
  "태초에 말씀이 있었다"
  (= "hello" (deref the-world))

  "더 간결히 쓸 수 있지만, 결국 같은 것이다"
  (= "hello" @the-world)

  "네가 세상에서 보기 원하는 변화, 네가 스스로 그 변화가 될 수 있다"
  (= "better" (do
          (dosync (ref-set the-world "better"))
          @the-world))

  "기존 값을 바탕으로 변경할 수 있다"
  (= "better!!!" (let [exclamator (fn [x] (str x "!"))]
          (dosync
           (alter the-world exclamator)
           (alter the-world exclamator)
           (alter the-world exclamator))
          @the-world))

  "트랜잭션 안에서 처리해야 하는 점을 잊지 마라"
  (= 0 (do (dosync
             (ref-set the-world 0))
           @the-world))

  "alter에 전달하는 함수는 ref에 담긴 데이터에 의존한다"
  (= 20 (do
          (dosync 
            (alter the-world (fn [_] 20)))
          @the-world))

  "두 세상이 하나보다 낫다"
  (= ["Real Jerry" "Bizarro Jerry"]
       (do
         (dosync
          (ref-set the-world {})
          (alter the-world assoc :jerry "Real Jerry")
          (alter bizarro-world assoc :jerry "Bizarro Jerry")
          (alter the-world (fn [x] (:jerry x)))
          (alter bizarro-world (fn [x] (:jerry x))))
        [@the-world @bizarro-world])))
