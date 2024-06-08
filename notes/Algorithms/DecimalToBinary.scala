//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * To get the binary number we need to convert the base 10 numbers to base 2.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Data Structures and Algorithms with Scala A Practitioners Approach
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object DecimalToBinary extends App {
  def decToBinConv(decimal: Int): String = {
    val seqOfDivByTwo = Iterator.iterate(decimal)(_ / 2)
    val binList = seqOfDivByTwo
      .takeWhile(_ > 0)
      .map(_ % 2)
    binList.mkString.reverse
  }

  println(decToBinConv(5)) // <- 101
  println(decToBinConv(8)) // <- 1000
}
