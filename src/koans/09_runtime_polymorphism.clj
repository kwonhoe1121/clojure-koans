(ns koans.09-runtime-polymorphism
  (:require [koan-engine.core :refer :all]))

(defn hello
  ([] "Hello World!")
  ([a] (str "Hello, you silly " a "."))
  ([a & more] (str "Hello to this group: "
                   (apply str
                          (interpose ", " (cons a more)))
                   "!")))

(defmulti diet (fn [x] (:eater x)))
(defmethod diet :herbivore [a] __)
(defmethod diet :carnivore [a] __)
(defmethod diet :default [a] __)

(meditations
  ;; "Some functions can be used in different ways - with no arguments"
  "어떤 함수는 여러 방식으로 사용되기도 한다 - 인수 없는 경우"
  (= __ (hello))

  ;; "With one argument"
  "인수 한 개를 받는 경우"
  (= __ (hello "world"))

  ;; "Or with many arguments"
  "또는 인수 여러 개를 받는 경우"
  (= __
     (hello "Peter" "Paul" "Mary"))

  ;; "Multimethods allow more complex dispatching"
  "멀티메소드(multimethod)로 좀 더 복잡한 처리가 된다"
  (= "Bambi eats veggies."
     (diet {:species "deer" :name "Bambi" :age 1 :eater :herbivore}))

  ;; "Animals have different names"
  "동물은 각각 이름이 있다"
  (= "Thumper eats veggies."
    (diet {:species "rabbit" :name "Thumper" :age 1 :eater :herbivore}))

  ;; "Different methods are used depending on the dispatch function result"
  "디스패치 함수 결과값에 따라 다른 메소드를 사용할 수 있다"
  (= "Simba eats animals."
     (diet {:species "lion" :name "Simba" :age 1 :eater :carnivore}))

  ;; "You may use a default method when no others match"
  "해당하는 것이 없으면 디폴트 메소드가 불린다"
  (= "I don't know what Rich Hickey eats."
     (diet {:name "Rich Hickey"})))
