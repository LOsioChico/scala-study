import java.util.Calendar

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * A lazy evaluation can be defined as a kind of delayed evaluation.
 *
 * What do we gain by making evaluations lazy?
 * On these examples below, we have smaller values to hold in the memory, but
 * imagine thousands of records being evaluated, if we are not using these
 * records then holding them in the computer's memory is wasteful
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Data Structures and Algorithms with Scala A Practitioners Approach
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Good to know: Apache Spark use lazy evaluation extensively
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object LazyEvaluation extends App {
  // Opposed to lazy evaluation, expression are evaluated at the time of the
  // program execution

  val myNum     = 10 // <- Immediately evaluated
  var myNextNum = 11 // <- Immediately evaluated

  println(myNum)     // 10
  println(myNextNum) // 11

  // On the above code snippet, both are evaluated immediately, irrespective of
  // they are used or not, in the following code snippet, lazyTime is defined
  // before eagerTime and after the sleep this has higher value

  lazy val lazyTime = Calendar.getInstance.getTime // <- Delayed evaluation
  val eagerTime     = Calendar.getInstance.getTime // <- Immediate evaluation

  Thread.sleep(2000) // Wait 2 seconds to see the difference

  println(lazyTime)  // <- Evaluated here
  println(eagerTime) // <- Already evaluated

  // Another way for evaluation lazy is to ask the compiler for delayed
  // parameter evaluation. This can be done using functions as parameters

  def myMethod(myArg: () => Int): Unit = // <- Delayed evaluation
    println(myArg()) // <- Evaluated here after call

  myMethod(() => 5)

  // When myMethod is called, the Int argument is not evaluated. It's evaluated
  // at the time of printing because that is when it is needed
}
