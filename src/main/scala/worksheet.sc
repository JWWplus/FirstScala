import scala.io.Source

val path = "/home/jiangweiwei/spark/README.md"

val  source = Source.fromFile(path)

val array = Array(1,2,3,4,5,6,7)
val num = 3.14
import scala.math._

def test: Unit ={
  print("jww")
}

val fun = test

val fun2: (Double)=>Double = ceil

(1 to 9) map {
  "*" * _
} foreach(println(_))

def curryfun(x:Int)(y:Int): Int = {
  x * y
}

val a = Array("HELLO", "WORLD")
val b = Array("hello", "worle")

a.corresponds(b)((c:String, d:String) => c.equalsIgnoreCase(d))

trait jww {
  def start()
}

1 to 10 toArray;
1 until 10 toArray