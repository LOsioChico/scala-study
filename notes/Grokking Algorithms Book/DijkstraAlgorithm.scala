//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Exercises: https://prnt.sc/1eMBUMbLw6Yj
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Algorithms Illustrated Programmers Curious (Ch7)
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

 */

object DijkstraAlgorithm extends App {

  // 7.1
  val graph1 = Map(
    "start" -> Map(Node("A") -> 5, Node("B") -> 2),
    "A"     -> Map(Node("C") -> 4, Node("D") -> 2),
    "B"     -> Map(Node("A") -> 8, Node("D") -> 7),
    "C"     -> Map(Node("D") -> 6, Node("finish") -> 3),
    "D"     -> Map(Node("finish") -> 1)
  )

  val costs1 = Map(
    Node("A")      -> 5,
    Node("B")      -> 2,
    Node("C")      -> Int.MaxValue,
    Node("D")      -> Int.MaxValue,
    Node("finish") -> Int.MaxValue
  )

  val parents1 = Map(
    Node("A")      -> Node("start"),
    Node("B")      -> Node("start"),
    Node("C")      -> Node(""),
    Node("D")      -> Node(""),
    Node("finish") -> Node("")
  )

}

case class Node(name: String)
