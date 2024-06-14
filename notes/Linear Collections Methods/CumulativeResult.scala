//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference:
 * https://stackoverflow.com/questions/17408880/reduce-fold-or-scan-left-right
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object CumulativeResult extends App {
  val abc = List("A", "B", "C")
  println(abc) // <- List(A, B, C)

  def add(res: String, x: String) = {
    println(s"op: $res + $x = ${res + x}")
    res + x
  }

  println(abc.reduceLeft(add))
  // op: A + B = AB
  // op: AB + C = ABC <- accumulates value AB in *first* operator arg `res`
  // ABC

  println(abc.foldLeft("z")(add)) // <- with start value "z"
  // op: z + A = zA <- initial extra operation
  // op: zA + B = zAB
  // op: zAB + C = zABC
  // zABC

  println(abc.scanLeft("z")(add))
  // op: z + A = zA <- same operations as foldLeft above...
  // op: zA + B = zAB
  // op: zAB + C = zABC
  // List(z, zA, zAB, zABC) <- ...but returns all intermediate results
}
