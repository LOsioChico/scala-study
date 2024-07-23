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
 * Reference: Grokking Algorithms Illustrated Programmers Curious (Ch1)
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object BinarySearch extends App {

  def findMaxSteps(namesList: List[Int]): Int =
    val seqOfDivByTwo = Iterator.iterate(namesList.length.toDouble)(_ / 2)
    val numOfSteps    = seqOfDivByTwo.takeWhile(_ > 1).length
    numOfSteps

  // 1.1
  val namesList11 = List.range(0, 128)
  println(findMaxSteps(namesList11)) // <- 7

  // 1.2
  val namesList12 = List.range(0, namesList11.length * 2)
  println(findMaxSteps(namesList12)) // <- 8
  
}
