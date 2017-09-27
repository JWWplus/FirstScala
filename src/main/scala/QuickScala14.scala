/**
  * Created by jiangweiwei on 17-9-25.
  */
object QuickScala14 {
  def main(args: Array[String]): Unit = {
    val result = swap(10, 20)
    println(result)

    val array = swap2(Array(1,2765,3,4,5,2,1))
    println(array.mkString)

    val l: List[Any] = List(List(3, 8), 2, List(5))
    println(leafsum(l))
  }

  def swap[T, K](tuple: (T, K)): (K, T) = {
    tuple match {
      case (a, b) => (b, a)
    }
  }

  def swap2(array: Array[Any]): Array[Any] = {
    if (array.length < 2)
      array
    else {
      array match {
        case Array(first, second, rest @ _*) => Array(second, first) ++ rest
      }
    }
  }

  def leafsum(list:List[Any]):Int = {
    var total = 0
    list.foreach {
      case l: List[Any] => total += leafsum(l)
      case num: Int => total += num
      case _ => total += 0
    }
    total
  }
}
