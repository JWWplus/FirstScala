/**
  * Created by jiangweiwei on 17-9-20.
  */
import scala.collection.mutable.{ArrayBuffer, HashMap, ListBuffer, SortedSet}
import java.util.TimeZone.getAvailableIDs
import scala.collection.immutable.{HashMap=>imhash}


object QuickScala13 {
  def main(args: Array[String]): Unit = {
    val str = "Mississippi"
    mapCount(str)
    println(removedouble1(str))
    println(mapCollection())

    val array = new ArrayBuffer[String] with mymkstring
    array += "jww"
    array += " wy"
    array += " rd"
    array += " eeds"
    array += " ewq"
    array += "ewq"
    println(array.mymkstring)

    funtuple()

    array2dim(array.toArray, 2).foreach(
      item => {
        println("=========")
        item.foreach(println)
      }
    )

    println(getMaxTimeArea)
    getFrequence
  }

  def mapCount(str: String): Unit = {
    val mapresult = new HashMap[Char, ListBuffer[Int]]()

    for (i <- str.zipWithIndex) {
      var key = i._1
      mapresult.get(key) match {
        case Some(result) => mapresult(key) = mapresult(key) :+ i._2
        case None => mapresult(key) = ListBuffer(i._2)
      }
    }

    println(mapresult)
  }

  def mapStrIndex(str:String)={
    var indexMap = new HashMap[Char,SortedSet[Int]]()
    var i = 0
    str.toCharArray.foreach {
      c =>
        indexMap.get(c) match {
          case Some(result) => indexMap(c) = result + i
          case None => indexMap += (c -> SortedSet {
            i
          })
        }
        i += 1
    }
    indexMap
  }

  def removedouble1(str:String) = {
    val result = str.zipWithIndex.filter(x => x._2 % 2 == 0)
    result
  }

  def mapCollection() = {
    val array = Array("jiangweiwei", "weiyan", "chengyi", "licheng")
    val map = Map(
      "jiangweiwei" -> 1,
      "weiyan" -> 2,
      "licheng" -> 3,
      "zhangke" -> 4
    )

    array.flatMap(map.get(_)).mkString
  }

  def funtuple() = {
    val list1 = List(5.0, 1.2, 3.3)
    val list2 = List(212, 3214, 21)

    println((list1 zip list2).map(Function.tupled(_ * _)))
  }

  def array2dim(array: Array[String], i: Int) = {
    array.grouped(i)
  }

  def getMaxTimeArea(): Int = {
    getAvailableIDs.groupBy(_.split("/")(0)).reduceLeft(
      (x ,y) => if (x._2.length > y._2.length) x else y
    )._2.length
  }

  def getFrequence(): Unit = {
    val test = "jiangweiweiweiyanlicheng"

    val frequence = test.par.aggregate(imhash[Char, Int]())(
      (map, item) => {
        map + (item -> (map.getOrElse(item, 0) + 1))
      },
      (map1, map2) => {
        (map1.keySet ++ map2.keySet).foldLeft(imhash[Char, Int]())(
          (result, k) => {
            result + (k -> (map1.getOrElse(k, 0) + map2.getOrElse(k, 0)))
          }
        )
      }
    )
    for (i <- frequence) {
      println(i._1 + "  " + i._2)
    }
  }
}

trait mymkstring {
  this: scala.collection.mutable.Iterable[String] =>

  def mymkstring = if (this != Nil) this.reduceLeft(_+_)
}
