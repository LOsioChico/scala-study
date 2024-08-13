//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * This binary search algorithm has a time complexity of O(log n), since the
 * running time increases logarithmically with the size of the input. If the
 * input size is n, it will take approximately log(n) steps to complete the
 * binary search.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Data Structures & Algorithms for Coding Interviews
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object BinarySearchR extends App {

  def binarySearch(inputList: List[Int], target: Int) =
    def iter(inputList: List[Int], target: Int, low: Int, high: Int): Int =
      inputList match
        case head :: tail =>
          val mid = (low + high) / 2
          if inputList(mid) < target then iter(inputList, target, mid + 1, high)
          else if inputList(mid) > target then iter(inputList, target, low, mid - 1)
          else mid
        case Nil => -1

    iter(inputList, target, 0, inputList.length - 1)

  val sortedElements = List[Int](2, 3, 4, 10, 40)
  val searchValue    = 10
  println(binarySearch(sortedElements, searchValue)) // <- 3
}
