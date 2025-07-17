/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * This implementation of the Fibonacci sequence has a time complexity of O(2^n)
 * which is exponential in the size of the input. This is because each call to
 * fibonacci(n) results in two additional recursive calls to fibonacci(n - 1)
 * and fibonacci(n - 2).
 *
 * The time complexity of this algorithm is determined by the number of recursive
 * calls that are made. Each recursive call processes one element, so the total
 * number of recursive calls is approximately 2^n. The running time of each rec
 * call is O(1), so the total running time is O(2^n).
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Data Structures & Algorithms for Coding Interviews
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object Fibonnaci extends App {

  // Time O(2^n) - Space O(n)
  def fibonnaciNthVal(num: Int): Int =
    if num <= 1 then num
    else fibonnaciNthVal(num - 1) + fibonnaciNthVal(num - 2)

  val input = 10
  println(s"Fibonacci number at position $input is ${fibonnaciNthVal(input)}")
  // Fibonacci number at position 10 is 55
}
