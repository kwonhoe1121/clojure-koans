(ns koans.13-recursion
  (:require [koan-engine.core :refer :all]))

(defn is-even? [n]
  (if (= n 0)
    __
    (___ (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      __
      (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  __)

(defn factorial [n]
  __)

(meditations
  ;; "Recursion ends with a base case"
  "재귀는 종료 기준이 있다"
  (= true (is-even? 0))

  ;; "And starts by moving toward that base case"
  "그리고 그 종료 기준을 위해 나아가며 시작한다"
  (= false (is-even? 1))

  ;; "Having too many stack frames requires explicit tail calls with recur"
  "너무 많은 스택 프레임이 필요한 경우 recur로 명시적인 꼬리재귀호출(tail call)이 필요하다"
  (= false (is-even-bigint? 100003N))

  ;; "Reversing directions is easy when you have not gone far"
  "너무 멀리 가지 않았다면 되돌아가기 쉽다"
  (= '(1) (recursive-reverse [1]))

  ;; "Yet it becomes more difficult the more steps you take"
  "더 걸어갈 수록 힘들어지지만 말이다"
  (= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5]))

  ;; "Simple things may appear simple."
  "간단한 것들은 겉보기에도 간단하다"
  (= 1 (factorial 1))

  ;;"They may require other simple steps."
  "간단한 몇 단계를 더 필요로 하기도 한다"
  (= 2 (factorial 2))

  ;; "Sometimes a slightly bigger step is necessary"
  "어떨 때는 조금 큰 단계가 필요하다"
  (= 6 (factorial 3))

  ;; "And eventually you must think harder"
  "그리고 결국은 열심히 생각해야만 한다"
  (= 24 (factorial 4))

  ;; "You can even deal with very large numbers"
  "매우 큰 숫자를 다룰 수도 있겠지만"
  (< 1000000000000000000000000N (factorial 1000N))

  ;; "But what happens when the machine limits you?"
  "기계가 더 이상 받쳐주지 않을 때는 어떻게 할 것인가?"
  (< 1000000000000000000000000N (factorial 100003N)))
