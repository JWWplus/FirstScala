/**
  * Created by jiangweiwei on 17-9-12.
  */
import java.io.File

object QuickScala11 {
  def main(args: Array[String]): Unit = {
    val path = "/home/jiangweiwei/Doc/notes/README.md"
    val filepath = RichFile(path)

    var RichFile(path1, path2) = filepath

    println(s"path1:${path1}, path2:${path2}")
  }
}

class RichFile(val path: String) extends File(path) {
  
}

object RichFile {
  def unapply(richFile: RichFile): Option[(String, String)] = {
    val path = richFile.path
    val index = path.lastIndexOf("/")
    if (index == -1) None else Some((path.substring(0, index), path.substring(index+1)))
  }

  def unapplySeq(richFile: RichFile): Option[Seq[String]] = {
    if (richFile.path.trim == "") None else Some(richFile.path.trim.split("/"))
  }

  def apply(path: String): RichFile = new RichFile(path)
}
