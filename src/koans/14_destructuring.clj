(ns koans.14-destructuring
  (:require [koan-engine.core :refer :all]))

(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

(meditations
  ;; "Destructuring is an arbiter: it breaks up arguments"
  "디스트럭쳐링(destructuring)으로 전달인자를 나눌 수 있다"
  (= __ ((fn [[a b]] (str b a))
         [:foo :bar]))

  ;; "Whether in function definitions"
  "함수 정의에서도 쓸 수 있고"
  (= (str "First comes love, "
          "then comes marriage, "
          "then comes Clojure with the baby carriage")
     ((fn [[a b c]] __)
      ["love" "marriage" "Clojure"]))

  ;; "Or in let expressions"
  "또는 let 표현식에서도 쓴다"
  (= "Rich Hickey aka The Clojurer aka Go Time aka Macro Killah"
     (let [[first-name last-name & aliases]
           (list "Rich" "Hickey" "The Clojurer" "Go Time" "Macro Killah")]
       __))

  ;; "You can regain the full argument if you like arguing"
  "전체 전달인자를 되찾을 수 있다"
  (= {:original-parts ["Stephen" "Hawking"] :named-parts {:first "Stephen" :last "Hawking"}}
     (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]]
       __))

  ;; "Break up maps by key"
  "맵(map)을 키(key)로 나눠 받을 수 있다"
  (= "123 Test Lane, Testerville, TX"
     (let [{street-address :street-address, city :city, state :state} test-address]
       __))

  ;; "Or more succinctly"
  "아니면 더 간명하게도"
  (= "123 Test Lane, Testerville, TX"
     (let [{:keys [street-address __ __]} test-address]
       __))

  ;; "All together now!"
  "전부 다 써보자!"
  (= "Test Testerson, 123 Test Lane, Testerville, TX"
     (___ ["Test" "Testerson"] test-address)))
