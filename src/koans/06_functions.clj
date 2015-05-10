(ns koans.06-functions
  (:require [koan-engine.core :refer :all]))

(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

(meditations
  ; "Calling a function is like giving it a hug with parentheses"
  "함수를 호출하는 것은 마치 괄호와 인사하는 것 같다"
  (= __ (square 9))

  ; "Functions are usually defined before they are used"
  "함수는 보통 쓰기 전에 미리 정의한다"
  (= __ (multiply-by-ten 2))

  ; "But they can also be defined inline"
  "그러나 곧바로 정의해 쓸 수도 있다"
  (= __ ((fn [n] (* 5 n)) 2))

  ; "Or using an even shorter syntax"
  "아니면 훨씬 간단한 문법으로 쓸 수도 있다"
  (= __ (#(* 15 %) 4))

  ; "Even anonymous functions may take multiple arguments"
  "익명 함수도 여러 인자를 받을 수 있다"
  (= __ (#(+ %1 %2 %3) 4 5 6))

  ; "Arguments can also be skipped"
  "필요 없는 인자는 건너 뛸 수도 있다"
  (= __ (#(* 15 %2) 1 2))

  ; "One function can beget another"
  "한 함수가 다른 함수를 만들어 낼 수 있다"
  (= 9 (((fn [] ___)) 4 5))

  ; "Functions can also take other functions as input"
  "함수가 다른 함수를 입력값으로 받을 수도 있다"
  (= 20 ((fn [f] (f 4 5))
           ___))

  ; "Higher-order functions take function arguments"
  "고차함수(Higher-order functions)는 함수를 인자로 받는다"
  (= 25 (___
          (fn [n] (* n n))))

  ; "But they are often better written using the names of functions"
  "그러나 함수 이름을 사용하는 것이 나을 때가 많다"
  (= 25 (___ square)))
