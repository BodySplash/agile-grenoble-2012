(ns agile-grenoble.life)

(def init #{[9 10]
            [10 10]
            [11 10]})

(defn sera-vivante? [cellules cellule n]
  (if (contains? cellules cellule)
                (or (= 2 n) (= 3 n))
                (= 3 n)))

(defn voisins [[x y]]
  (for [dx [-1 0 1]
        dy [-1 0 1]
    :when (not= dx dy 0)]
    [(+ x dx) (+ y dy)]))

(defn generation-suivante
[cellules]
(let [freqs (frequencies 
              (mapcat voisins cellules))]
  (for [[cellule n] freqs
        :when (sera-vivante? cellules cellule n)]
    cellule)))
