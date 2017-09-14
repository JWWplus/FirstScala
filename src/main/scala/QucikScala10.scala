/**
  * Created by jiangweiwei on 17-9-12.
  */
import java.awt.geom.Ellipse2D
import java.awt.Point

object QucikScala10 {
  def main(args: Array[String]): Unit = {

/*    val double = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
    double.transform(10, 20)
    double.grow(100, 200)*/

    val name = "jiangweiwei"
    val logger = new CryptoLogger()
    println(logger.log(name, 2))

  }

}

trait Loger {
  def log(msg:String, key:Int = 3): String
}

class CryptoLogger extends Loger {
  def log(msg: String, key: Int): String = {
    for (i <- msg) yield if (key >= 0) (97 + ((i - 97 + key)%26)).toChar else (97 + ((i - 97 + 26 + key)%26)).toChar
  }
}


trait RectangleLike {
  this: Ellipse2D.Double =>

  def transform(x: Double, y: Double): Unit = {
    this.x = x
    this.y = y
  }

  def grow(x:Double, y:Double): Unit ={
    this.x += x
    this.y += y
  }
}

class OrderPoint(x:Int, y:Int) extends Point(x, y) with scala.math.Ordered[OrderPoint] {
  override def compare(that: OrderPoint): Int = {
    if (this.x == that.x && this.y == that.y)
      0
    else if (this.x < that.x || (this.x == that.x && this.y < that.y))
      -1
    else
      1
  }
}