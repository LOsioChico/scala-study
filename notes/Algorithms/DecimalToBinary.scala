/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * To get the binary number we need to convert the base 10 numbers to base 2.
 *
 * First, we need to creates a sequence of numbers by dividing the given number
 * by 2 ultil it is less than 2 and save the quotient, then divide each number
 * by 2 and store the remainder. The bits are accumulated in this container in
 * reverse order so we can use the reverse method.
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
