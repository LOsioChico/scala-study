//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Extends the Seq prototype with a method that returns the element at the
 * specified index. If the index is negative, it is used as an offset from the
 * end of the seq.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object At extends App {
  extension [T](arr: Seq[T]) {
    def at(index: Int): T = {
      if (index < 0) arr(arr.length + index)
      else arr(index)
    }
  }

  val arr = Seq(1, 2, 3, 4, 5)

  println(arr.at(-2)) // Output: 4
  // The index -2 is used as an offset from the end of the seq
}