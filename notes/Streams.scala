//> using scala "3.3.1"

import scala.collection.immutable.Stream.{empty, cons}

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * In Scala we can use lazy evaluation¹ and implement memoization², the lazy
 * evaluation is native on Scala (using the reserved word lazy) and we can
 * implement it too with delayed parameter evaluation, for the memoization we
 * should write some lines of code to implement with a data structure like Map
 *
 * Fortunately, we don't have to implement manually, we can just use Scala's
 * Stream which is:
 * - Lazy evaluated
 * - Memoized
 * - Immutable
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Data Structures and Algorithms with Scala A Practitioners Approach
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Relationated: LazyEvaluation.scala¹, MemoizationImplements.scala²
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object Streams extends App {
  val messageStream = Stream("message 1", "message 2", "message 3")
  println(messageStream) // <- Stream(message 1, <not computed>)

  // Even though we supplied three messages, only the first is listed, which
  // means only the first element of the stream was computed. It's lazy computed

  println(messageStream(1)) // <- "message 2"
  println(messageStream)    // <- Stream(message 1, message 2, <not computed>)

  // Now the second element is computed, this only compute the second element,
  // this is truly lazy computation.

  val numStream = Stream(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(numStream) // <- Stream(0, <not computed>)

  println(numStream(3)) // <- 3
  println(numStream)    // <- Stream(0, 1, 2, 3, <not computed>)

  println(numStream(9)) // <- 9
  println(numStream) // <- Stream(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, <not computed>)

  // The code above is intuitive. Only compute the elements until the index.

  // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

  // Streams can also de created using the #:: operator, ends with a empty Stream

  val charStream = 'a' #:: 'b' #:: 'c' #:: 'd' #:: empty
  println(charStream) // <- Stream(a, <not computed>)

  // Another way to create Streams is using the cons function

  val charStream2 = cons('a', empty)
  println(charStream2) // <- Stream(a, <not computed>)

  // Now, infinite sequences are common in mathematics. They solve some of the
  // most demanding computing problems like handling continuosly generated log
  // files, tweets, etc.

  def createInfNumStream(x: Int): Stream[Int] = {
    println(s"Processing $x")
    cons(x, createInfNumStream(x + 1))
  }

  val infNumStream = createInfNumStream(0)
  println(infNumStream)
  // Processing 0
  // Stream(0, <not computed>)

  println(infNumStream(0))
  // 0

  println(infNumStream(1))
  // Processing 1
  // 1

  println(infNumStream(5))
  // Processing 2
  // Processing 3
  // Processing 4
  // Processing 5
  // 5

  println(infNumStream(5))
  // 5

  println(infNumStream)
  // Stream(0, 1, 2, 3, 4, 5, <not computed>)

  // Now, let's test the inmmutability on the Streams, this is commented to
  // not broke unnecessary the execution

  // infNumStream(5) = 15
  // error: value update is not a member of Stream[Int]

  // We tried to assign a new value at index 5, since Stream is immutable, it
  // refused our request to update

  // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

  // Now, let's look at Stream to List conversion.
  // We need to be careful during Stream to List conversion

  println(infNumStream.take(5).toList) // <- List(0, 1, 2, 3, 4)

  // This one terminates bc we limited the number of elements in the stream,
  // which limited the evaluation and the computation terminated

  // println(infNumStream.toList) // <- Commented to not broke the execution
  // Processing 6
  // Processing 7
  // Processing 8
  // Processing 9
  // (Infinite calculations) ...

  // This one we gave an infinite set of numbers, so it kept evaluationg those
  // numbers first. Evaluation completes before conversion.

  // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

  def createFiboSeries(a: Int = 0, b: Int = 1): Stream[Int] = {
    cons(a, createFiboSeries(b, a + b))
  }

  val myFiboSeries = createFiboSeries()
  println(myFiboSeries) // <- Stream(0, <not computed>)

  myFiboSeries.take(7).foreach(println) // <- We limited computation to first 7
  // 0
  // 1
  // 1
  // 2
  // 3
  // 5
  // 8
}
