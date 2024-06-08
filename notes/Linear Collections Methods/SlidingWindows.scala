//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * A Sliding Window enables us to break a list into smaller lists based on the
 * window specification that we provide. When is used in the right context it
 * gives us tools to model efficient solutions to a programming problem.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Data Structures and Algorithms with Scala A Practitioners Approach
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object SlidingWindows extends App {
  val myNums = List(1, 2, 3, 4, 5)
  println(myNums) // <- List(1, 2, 3, 4, 5)

  // The signature of the sliding method is sliding(size: Int, step: Int), where
  // size is the number of elements per group and step is the distance between
  // the first elements.

  println(myNums.sliding(size = 2, step = 1).toList)
  // List(List(1, 2), List(2, 3), List(3, 4), List(4, 5))

  println(myNums.sliding(1, 2).toList)
  // List(List(1), List(3), List(5))
}
