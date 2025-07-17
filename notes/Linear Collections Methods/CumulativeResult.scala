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

  // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

  def tabulateFunc(i: Int) = {
    println(s"op: $i * X = ${"X" * i}")
    "X" * i
  }

  println(Seq.tabulate(5)(tabulateFunc))
  // op: 0 * X =
  // op: 1 * X = X
  // op: 2 * X = XX
  // op: 3 * X = XXX
  // op: 4 * X = XXXX
  // List(, X, XX, XXX, XXXX)

  def iterateFunc(s: String) = {
    println(s"op: $s + X = ${s + "X"}")
    s + "X"
  }

  println(Seq.iterate("", 5)(iterateFunc))
  // op:  + X = X
  // op: X + X = XX
  // op: XX + X = XXX
  // op: XXX + X = XXXX
  // List(, X, XX, XXX, XXXX)

  def unfoldFunc(s: String) = {
    println(s"op: $s = ${if s.isEmpty then None else Some(s, s.tail)}")
    if s.isEmpty then None else Some(s, s.tail)
  }

  println(Seq.unfold("XXXX")(unfoldFunc))
  // op: XXXX = Some(XXXX, XXX)
  // op: XXX = Some(XXX, XX)
  // op: XX = Some(XX, X)
  // op: X = Some(X, )
  // op:  = None
  // List(XXXX, XXX, XX, X)
}
