//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Functional Programming Principles in Scala | Coursera
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object SeqOperations extends App {
  val list = List(1, 2, 3, 4, 5)
  println(list) // <- List(1, 2, 3, 4, 5)

  val splitAt = list.splitAt(2) // Same as (list take 2, list drop 2)
  println(splitAt) // <- (List(1, 2),List(3, 4, 5))

  val concat = list ++ "ab" // Concatenation, complexity O(n)
  println(concat) // <- List(1, 2, 3, 4, 5, a, b)

  val typeSafeConcat = list ::: List(6, 7, 8) // Concatenation, complexity O(n)
  println(typeSafeConcat) // <- List(1, 2, 3, 4, 5, 6, 7, 8)

  val filterNot = list.filterNot(_ % 2 == 0)
  println(filterNot) // <- List(1, 3, 5)

  val partition = list.partition(_ % 2 == 0)
  println(partition) // <- (List(2, 4),List(1, 3, 5))

  // The longest prefix consisting of elements that satisfy p
  val takeWhile = list.takeWhile(_ < 4)
  println(takeWhile) // <- List(1, 2, 3)

  // The remainder of the list after any leading element satisfying p have been
  // removed
  val dropWhile = list.dropWhile(_ < 4)
  println(dropWhile) // <- List(4, 5)

  // Same as (xs takeWhile p, xs dropWhile p)
  val span = list.span(_ < 4)
  println(span) // <- (List(1, 2, 3),List(4, 5))

  val groupBy = list.groupBy(_ % 2)
  println(groupBy) // <- Map(1 -> List(1, 3, 5), 0 -> List(2, 4))

  val distinct = List(1, 2, 1, 3, 4, 2, 5).distinct // Removes duplicates
  println(distinct) // <- List(1, 2, 3, 4, 5)
}
