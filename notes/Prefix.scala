/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Scala Excercises
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object Prefix extends App {

  class Stereo {
    // To make prefixes work, the method name must be unary_ followed by the operator
    def unary_+ : String = "on"
    def unary_- : String = "off"
  }

  val stereo = new Stereo
  println(+stereo) // <- calls stereo.unary_+ so prints "on"
  println(-stereo) // <- calls stereo.unary_- so prints "off"

}
