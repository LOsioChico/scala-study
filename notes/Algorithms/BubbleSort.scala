//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Data Structures & Algorithms for Coding Interviews
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object BubbleSort extends App {

  def bubbleSort(inputList: List[Int]) =
    def iter(list: List[Int], current: Int, to: Int): List[Int] =
      to match
        case 0                    => list
        case _ if (current == to) => iter(list, 0, to - 1)
        case _ =>
          if (list(current) > list(current + 1)) then
            val updatedCurrent = list.updated(current, list(current + 1))
            val updatedNext    = updatedCurrent.updated(current + 1, list(current))
            iter(updatedNext, current + 1, to)
          else iter(list, current + 1, to)

    iter(inputList, 0, inputList.length - 1)

  val sortedElements = List[Int](64, 34, 25, 12, 22, 11, 90)
  println(bubbleSort(sortedElements)) // <- List(11, 12, 22, 25, 34, 64, 90)
}
