//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * This implementation of quick sort hast a time complexity of O(n log n), on
 * average. In the worst case, the time complexity is O(n^2), if the pivot is
 * always the smallest or largest element in the array.
 * 
 * The time complexity of quick sort is determinated by the number of recursive
 * calls that are made. Each recursive call processes approximately n / 2 elems,
 * so the total number of recursive calls is aproximately log n. The running
 * time of each recursive call is O(n), so the total running time is o (n log n)
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Data Structures & Algorithms for Coding Interviews
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object QuickSort extends App {

  // Time O(n log n) - Space O(n)
  def bubbleSort(nums: List[Int]): List[Int] =
    if nums.length <= 1 then nums
    else
      val pivot = nums(nums.length / 2)
      val (left, middle, right) = nums.foldLeft((List.empty[Int], List.empty[Int], List.empty[Int])) {
        case ((left, middle, right), num) =>
          if num < pivot then (left :+ num, middle, right)
          else if num > pivot then (left, middle, right :+ num)
          else (left, middle :+ num, right)
      }
      bubbleSort(left) :++ middle :++ bubbleSort(right)

  val elements = List[Int](3, 6, 8, 10, 1, 2, 1)
  println(bubbleSort(elements)) // <- List(1, 1, 2, 3, 6, 8, 10)
}
