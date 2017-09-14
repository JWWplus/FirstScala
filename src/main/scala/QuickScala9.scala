/**
  * author: jiangweiwei
  * date: 2017-09-10
  */
import java.io.{File, PrintWriter}
import scala.io.Source
import scala.math

object QuickScala9 {
  def main(args: Array[String]): Unit = {
    //reverseFile()
    //relaceTab()
    //bigerThan12()
    //getDouble()
    //pow2()
    //printNotDouble()
    getImgSrc()
  }


  def getImgSrc(): Unit ={
    val path = "/home/jiangweiwei/test/test.html"
    val reader = Source.fromFile(path, "utf-8")

    val re = """<img.*?src=\"(.*?)\".*?>""".r

    val result = re.findAllMatchIn(reader.mkString)

    for (m <- result) {
      println(m.group(0))
    }
  }


  def printNotDouble(): Unit ={
    val path = "/home/jiangweiwei/test/test.md"
    val reader = Source.fromFile(path, "utf-8")

    val finalString = """[0-9]+\.[0-9]+""".r.replaceAllIn(reader.mkString, "")
    println(finalString)
  }

  def pow2(): Unit ={
    for (i <- 1 to 20) {
      val pow2 = math.pow(2, i)
      val _pow2 = 1 / pow2

      println("\t" + pow2 + "\t" + _pow2)
    }
  }

  def getDouble(): Unit ={
    val path = "/home/jiangweiwei/test/test.md"
    val reader = Source.fromFile(path, "utf-8")

    val array:Array[Double] = """[0-9]+\.[0-9]+""".r.findAllIn(reader.mkString).map(_.toDouble).toArray

    println(array.max)
    println(array.min)
    println(array.sum)
    println(array.sum / array.length)
  }


  def bigerThan12(): Unit ={
    val path = "/home/jiangweiwei/test/test.md"
    val reader = Source.fromFile(path, "utf-8")

    reader.mkString("").split("\\s+").filter(_.length > 10).map(println)
  }


  def reverseFile(): Unit = {
    val path = "/home/jiangweiwei/Doc/notes/hadoop/hadoop MR执行流程解析.md"
    val reader = Source.fromFile(path, "UTF-8").getLines()

    for (line <- reader.toArray.reverse) {
      println(line)
    }
  }


  def relaceTab(): Unit = {
    val path = "/home/jiangweiwei/test/test.md"

    val reader = Source.fromFile(path, "UTF-8").getLines()

    val changedlines = for (line <- reader) yield line.replaceAll("  ", "    ")

    for (i <- changedlines){
      println(i)
    }

    val writer = new PrintWriter("/home/jiangweiwei/test/test.md")
    changedlines.foreach(writer.println)

    writer.flush()
    writer.close()
  }
}
