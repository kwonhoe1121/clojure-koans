(ns koans.02-lists
  (:require [koan-engine.core :refer :all]))

(meditations
  ; "Lists can be expressed by function or a quoted form"
  "리스트는 함수나 인용된 형태로 표현할 수 있다"
  (= '(__ __ __ __ __) (list 1 2 3 4 5))

  ; "They are Clojure seqs (sequences), so they allow access to the first"
  "리스트는 클로저 시퀀스(sequences)이므로, 첫번째 값을 쉽게 읽을 수 있다"
  (= __ (first '(1 2 3 4 5)))

  ; "As well as the rest"
  "나머지 뒷부분을 접근하기도 쉽다"
  (= __ (rest '(1 2 3 4 5)))

  ; "Count your blessings"
  "너의 축복을 세어 보라"
  (= __ (count '(dracula dooku chocula)))

  ; "Before they are gone"
  "그 것들이 사라지기 전에"
  (= __ (count '()))

  ; "The rest, when nothing is left, is empty"
  "아무 것도 남지 않았을 때의 나머지는 빈 것이니라"
  (= __ (rest '(100)))

  ; "Construction by adding an element to the front is easy"
  "리스트 맨앞에 요소를 추가해서 만들기 쉽다"
  (= __ (cons :a '(:b :c :d :e)))

  ; "Conjoining an element to a list isn't hard either"
  "리스트 뒤에 요소를 합치는 것 역시 어렵지 않다"
  (= __ (conj '(:a :b :c :d) :e))

  ; "You can use a list like a stack to get the first element"
  "리스트를 스택처럼 쓰면서 맨 앞의 요소를 가져올 수 있다"
  (= __ (peek '(:a :b :c :d :e)))

  ; "Or the others"
  "아니면 그 나머지 값들도"
  (= __ (pop '(:a :b :c :d :e)))

  ; "But watch out if you try to pop nothing"
  "그러나, 빈 것에서 꺼낼 때는 조심하라"
  (= __ (try
          (pop '())
          (catch IllegalStateException e
            "No dice!")))

  ; "The rest of nothing isn't so strict"
  "나머지를 구하는 것은 그렇게 엄격하지 않다"
  (= __ (try
          (rest '())
          (catch IllegalStateException e
            "No dice!"))))
