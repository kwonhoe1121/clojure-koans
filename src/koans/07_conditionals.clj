(ns koans.07-conditionals
  (:require [koan-engine.core :refer :all]))

(defn explain-defcon-level [exercise-term]
  (case exercise-term
        :fade-out          :you-and-what-army
        :double-take       :call-me-when-its-important
        :round-house       :o-rly
        :fast-pace         :thats-pretty-bad
        :cocked-pistol     :sirens
        :say-what?))

(meditations
  "결정해야만 하는 일들이 많을 것이다"
  (= :a (if (false? (= 4 5))
          :a
          :b))

  "어떤 결정에는 대안이 없다"
  (= [] (if (> 4 3)
          []))

  "그리고 그런 경우에는 아무 것도 남지 않기도 한다"
  (= nil (if (nil? 0)
          [:a :b :c]))

  "때로는 대안이 흥미로울 수 있다"
  (= :glory (if (not (empty? ()))
              :doom
              :glory))

  "그대 앞에 매우 다양한 길이 있다"
  (let [x 5]
    (= :your-road (cond (= x 3) :road-not-taken
                        (= x 6) :another-road-not-taken
                        :else :your-road)))

  "아니, 어쩌면 그대의 운명은 이미 정해진 걸지도"
  (= 'doom (if-not (zero? 1)
          'doom
          'more-doom))

  "비상시에는 알람을 울려라"
  (= :sirens
     (explain-defcon-level :cocked-pistol))

  "그러나 무얼 해야할지 모르겠다면 그 사실을 인정하라"
  (= :say-what?
     (explain-defcon-level :yo-mama)))
