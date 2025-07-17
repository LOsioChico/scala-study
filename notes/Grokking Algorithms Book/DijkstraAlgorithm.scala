/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Exercises: https://prnt.sc/1eMBUMbLw6Yj
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Algorithms Illustrated Programmers Curious (Ch7)
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

 */

object DijkstraAlgorithm extends App {

  def computeDijkstra(graph: Map[Node, Map[Node, Int]], nodeWeights: Map[Node, Int], nodeParents: Map[Node, Node]) =
    assert(graph.values.forall(_.values.forall(_ >= 0)), "Graph contains negative edge(s)")

    def findLowestWeightNode(nodeWeights: Map[Node, Int], processedNodes: Set[Node]) =
      nodeWeights
        .filterNot { case (node, _) => processedNodes.contains(node) }
        .minByOption { case (_, weight) => weight }

    def iter(
        graph: Map[Node, Map[Node, Int]],
        nodeWeights: Map[Node, Int],
        nodeParents: Map[Node, Node],
        processedNodes: Set[Node] = Set[Node]()
    ): Map[Node, Int] =
      findLowestWeightNode(nodeWeights, processedNodes) match {
        case Some((node, weight)) =>
          val updatedProcessedNodes = processedNodes + node
          val neighbors             = graph(node)
          val (updatedNodeWeights, updatedNodeParents) = neighbors.foldLeft((nodeWeights, nodeParents)) {
            case ((weights, parents), (neighborNode, neighborWeight)) =>
              val newWeight = weight + neighborWeight
              if (weights(neighborNode) > newWeight)
                (weights + (neighborNode -> newWeight), parents + (neighborNode -> node))
              else (weights, parents)
          }
          iter(graph, updatedNodeWeights, updatedNodeParents, updatedProcessedNodes)
        case None => nodeWeights
      }

    iter(graph, nodeWeights, nodeParents)

  // 7.1
  val graph1 = Map(
    Node("start")  -> Map(Node("A") -> 5, Node("B") -> 2),
    Node("A")      -> Map(Node("C") -> 4, Node("D") -> 2),
    Node("B")      -> Map(Node("A") -> 8, Node("D") -> 7),
    Node("C")      -> Map(Node("D") -> 6, Node("finish") -> 3),
    Node("D")      -> Map(Node("finish") -> 1),
    Node("finish") -> Map()
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

  println(computeDijkstra(graph1, costs1, parents1)(Node("finish"))) // 8

  // 7.2
  val graph2 = Map(
    Node("start")  -> Map(Node("A") -> 10),
    Node("A")      -> Map(Node("B") -> 20),
    Node("B")      -> Map(Node("C") -> 1, Node("finish") -> 30),
    Node("C")      -> Map(Node("A") -> 1),
    Node("finish") -> Map()
  )

  val costs2 = Map(
    Node("A")      -> 10,
    Node("B")      -> Int.MaxValue,
    Node("C")      -> Int.MaxValue,
    Node("finish") -> Int.MaxValue
  )

  val parents2 = Map(
    Node("A")      -> Node("start"),
    Node("B")      -> Node(""),
    Node("C")      -> Node(""),
    Node("finish") -> Node("")
  )

  println(computeDijkstra(graph2, costs2, parents2)(Node("finish"))) // 60

  // 7.3
  val graph3 = Map(
    Node("start")  -> Map(Node("A") -> 2, Node("B") -> 2),
    Node("A")      -> Map(Node("finish") -> 2, Node("C") -> 2),
    Node("B")      -> Map(Node("A") -> 2),
    Node("C")      -> Map(Node("B") -> -1, Node("finish") -> 2),
    Node("finish") -> Map()
  )

  val costs3 = Map(
    Node("A")      -> 2,
    Node("B")      -> 2,
    Node("C")      -> Int.MaxValue,
    Node("finish") -> Int.MaxValue
  )

  val parents3 = Map(
    Node("A")      -> Node("start"),
    Node("B")      -> Node("start"),
    Node("C")      -> Node(""),
    Node("finish") -> Node("")
  )

  // AssertionError: assertion failed: Graph contains negative edge(s)
  // Negative edges are not allowed in Dijkstra's algorithm
  println(computeDijkstra(graph3, costs3, parents3)(Node("finish")))

}

case class Node(name: String)
