SELECT
  w.Id
FROM
  Weather w
WHERE
  EXISTS (
    SELECT
      1
    FROM
      Weather w1
    WHERE
      w1.recordDate = subdate(w.recordDate, 1)
      AND w1.Temperature < w.Temperature
  )