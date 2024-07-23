//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * EXERCISES
 *
 * 4.1 - Write out the code for the earlier sum function.
 * 4.2 - Write a recursive function to count the number of items in a list.
 * 4.3 - Find the maximum number in a list.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Algorithms Illustrated Programmers Curious (Ch4)
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object Recursion extends App {

  val numbers = List.range(1, 10)

  // 4.1
  def sum(nums: List[Int]): Int =
    nums match
      case head :: next => head + sum(next)
      case Nil          => 0

  println(sum(numbers)) // <- 45

  // 4.2
  def listLength(nums: List[Int]): Int =
    nums match
      case head :: next => 1 + listLength(next)
      case Nil          => 0

  println(listLength(numbers)) // <- 9

  // 4.3
  def findMaxNum(sourceNums: List[Int]): Int =
    def loop(nums: List[Int], currentMax: Int = Int.MinValue): Int =
      nums match
        case head :: next =>
          if head > currentMax then loop(next, head) else loop(next, currentMax)
        case Nil => currentMax

    loop(sourceNums)

  println(findMaxNum(numbers)) // <- 9

}
