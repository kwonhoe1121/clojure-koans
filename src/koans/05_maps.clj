(ns koans.05-maps
  (:require [koan-engine.core :refer :all]))

(meditations
  ; "Don't get lost when creating a map"
  "맵(map)을 만들때 길을 잃지 마라"
  (= {:a 1 :b 2} (hash-map :a 1 __ __))

  ; "A value must be supplied for each key"
  "모든 키(key)에 대응하는 값이 반드시 있어야 한다"
  (= {:a 1} (hash-map :a __))

  ; "The size is the number of entries"
  "그 크기는 엔트리(entry)의 수이다"
  (= __ (count {:a 1 :b 2}))

  ; "You can look up the value for a given key"
  "키로 그 값을 찾을 수 있다"
  (= __ (get {:a 1 :b 2} :b))

  ; "Maps can be used as functions to do lookups"
  "맵을 함수처럼 써서 값을 찾을 수 있다"
  (= __ ({:a 1 :b 2} :a))

  ; "And so can keywords"
  "키워드도 마찬가지다"
  (= __ (:a {:a 1 :b 2}))

  ; "But map keys need not be keywords"
  "맵의 키가 반드시 키워드일 필요는 없다"
  (= __ ({2010 "밴쿠버" 2014 "소치" 2018 "평창"} 2014))

  ; "You may not be able to find an entry for a key"
  "때로는 키로 엔트리를 찾지 못할 때도 있다"
  (= __ (get {:a 1 :b 2} :c))

  ; "But you can provide your own default"
  "그러나, 기본값을 준비할 수 있다"
  (= __ (get {:a 1 :b 2} :c :key-not-found))

  ; "You can find out if a key is present"
  "특정 키가 있는지 확인할 수 있다"
  (= __ (contains? {:a nil :b nil} :b))

  ; "Or if it is missing"
  "아니면 없는지도."
  (= __ (contains? {:a nil :b nil} :c))

  ; "Maps are immutable, but you can create a new and improved version"
  "맵은 불변(immutable)이지만, 엔트리를 추가한 새 버전을 만들 수 있다"
  (= {1 "해오름달" 2 __} (assoc {1 "해오름달"} 2 "시샘달"))

  ; "You can also create a new version with an entry removed"
  "한 엔트리를 제거한 새 버전을 만들 수도 있다"
  (= {__ __} (dissoc {1 "해오름달" 2 "시샘달"} 2))

  ; "Often you will need to get the keys, but the order is undependable"
  "키목록이 필요하면 구할 수 있지만, 순서는 보장되지 않는다"
  (= (list __ __ __)
     (sort (keys { 2014 "소치" 2018 "평창" 2010 "밴쿠버"})))

  "값들도 비슷한 방법으로 구할 수 있다"
  (= (list __ __ __)
     (sort (vals {2010 "밴쿠버" 2014 "소치" 2018 "평창"}))))
