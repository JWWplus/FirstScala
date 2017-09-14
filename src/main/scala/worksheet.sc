import scala.io.Source

val path = "/home/jiangweiwei/spark/README.md"

val  source = Source.fromFile(path)

val array = Array(("1",1), ("5", 5), ("3", 3))
val num = 3.14

array.max(Ordering[Int].reverse.on[(_, Int)](_._2))

var list = List(12,3,4,21,123,4123321,3)

val list2 = List(1)

val set = Set(1,2,4,1,2,3)

list.groupBy(_ % 2)