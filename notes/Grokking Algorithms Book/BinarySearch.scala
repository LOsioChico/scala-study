//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * EXERCISES
 *
 * 1.1 - Suppose you have a sorted list of 128 names, and you’re searching
 * through it using binary search. What’s the maximum number of steps it would take?
 * 1.2 - Suppose you double the size of the list. What’s the maximum
 * number of steps now?
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Algorithms Illustrated Programmers Curious
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object BinarySearch extends App {

  def findMaxSteps(listLength: Int): Int =
    val seqOfDivByTwo = Iterator.iterate(listLength.toDouble)(_ / 2)
    val numOfSteps    = seqOfDivByTwo.takeWhile(_ > 1).length
    numOfSteps

  // 1.1
  val listLength11 = 128
  println(findMaxSteps(listLength11)) // <- 7

  // 1.2
  val listLenght12 = listLength11 * 2
  println(findMaxSteps(listLenght12)) // <- 8
  
}
