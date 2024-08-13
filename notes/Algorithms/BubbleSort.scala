//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * This bubble sort algoithm has a time complexity of O(n^2), since the running
 * time is quadratic in the size of the input. If the input size is n, it will
 * take approximately n^2 steps to complete the bubble sort.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Data Structures & Algorithms for Coding Interviews
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object BubbleSort extends App {

  def bubbleSort(inputList: List[Int]) =
    def iter(nums: List[Int], current: Int, to: Int): List[Int] =
      to match
        case 0                    => nums
        case _ if (current == to) => iter(nums, 0, to - 1)
        case _ =>
          if (nums(current) > nums(current + 1)) then
            val updatedCurrent = nums.updated(current, nums(current + 1))
            val updatedNext    = updatedCurrent.updated(current + 1, nums(current))
            iter(updatedNext, current + 1, to)
          else iter(nums, current + 1, to)

    iter(inputList, 0, inputList.length - 1)

  val sortedElements = List[Int](64, 34, 25, 12, 22, 11, 90)
  println(bubbleSort(sortedElements)) // <- List(11, 12, 22, 25, 34, 64, 90)
}
