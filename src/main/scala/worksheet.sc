import java.util.TimeZone.getAvailableIDs

import scala.collection.mutable

val res = getAvailableIDs.groupBy(_.split("/")(0)).reduceLeft(
  (x ,y) => if (x._2.length > y._2.length) x else y
)._2.length



import scala.collection.mutable.{HashMap=>muhash}

val hashMap = Map[Char, Int]()

hashMap + ('j' -> 1)

