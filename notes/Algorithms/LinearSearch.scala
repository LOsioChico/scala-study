//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * This linear search algorithm hasta a time complexity of O(n), since the
 * running time time is directly proportional to the size of the input. If the
 * input size is n, the linear search will nake n steps to complete.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Data Structures & Algorithms for Coding Interviews
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object LinearSearch extends App {

  // Time O(n) - Space O(1)
  def linearSearch(inputList: List[Int], target: Int) =
    def iter(nums: List[Int], target: Int, index: Int = 0): Int =
      nums match
        case head :: tail =>
          if head == target then index
          else iter(tail, target, index + 1)
        case Nil => -1

    iter(inputList, target)

  val elements    = List[Int](3, 5, 7, 9, 11)
  val searchValue = 7
  println(linearSearch(elements, searchValue)) // <- 2
}
