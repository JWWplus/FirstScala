import scala.collection.immutable

/**
  * Created by jiangweiwei on 17-9-14.
  */

object QuickScala12 {
  def main(args: Array[String]): Unit = {

/*    for(j <- values(x=> x*x, -5 ,5)){
      println(j)
    }*/

/*    val array = Array(12,3,432,12,434,121,445,67,75,43)
    println(getMax(array))*/

    //println(factorial(5))

/*    println(factorial_plus(-5))

    println(largest(x=> 10 * x - x * x, 1 to 10))

    println(largest_plus(x=> 10 * x - x * x, 1 to 10))*/


  }

  def values(fun:(Int)=>Int, low:Int, high:Int) = {
    for (i <- low to high) yield {
      (i, fun(i))
    }
  }

  def getMax(array: Array[Int]): Int = {
    array.reduceLeft((a, b) => if(a > b) a else b)
  }

  def factorial(n: Int): Int = {
    1 to n reduceLeft(_ * _)
  }

  def factorial_plus(n: Int): Int = {
    (1 to n).product
  }

  def largest(fun: (Int)=>Int, input: Seq[Int]) = {
    input.map(fun(_)).max
  }

  def largest_plus(fun: (Int)=>Int, input: Seq[Int]) = {
    //input.reduce((x ,y) => if (fun(x) > fun(y)) x else y)
    input.map(x => (x, fun(x))).reduceLeft((y, z) => if (y._2 > z._2) y else z)._2
  }

}
