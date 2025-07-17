/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Memoization is a technique in which results of previous calculations are
 * stored so that they can be reused for future calculations.
 * - Helps to avoid recomputing (fibonacci is an example)
 * - In the case of a very large data set this save CPU time
 *
 * Is helpful even if local CPUs are not directly used, example of this could be
 * a numerous web service calls that request the same information then those can
 * be cached
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Data Structures and Algorithms with Scala A Practitioners Approach
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Good to know: Caching-related questions are common in many software
 * engineering job interviews. You might be asked to design and implement a
 * caching strategy.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object Memoization extends App {
  // Factorial without memoization, it performs computation in ever spet, which
  // can be seen in the console output. Running again it will be recomputed
  def calcFactorial(x: Int): Int = {
    if (x == 0 || x == 1) 1
    else
      println(s"Computing factorial $x (without memoization)")
      x * calcFactorial(x - 1)
  }

  calcFactorial(5)
  // Computing factorial 5 (without memoization)
  // Computing factorial 4 (without memoization)
  // Computing factorial 3 (without memoization)
  // Computing factorial 2 (without memoization)

  calcFactorial(5)
  // Computing factorial 5 (without memoization)
  // Computing factorial 4 (without memoization)
  // Computing factorial 3 (without memoization)
  // Computing factorial 2 (without memoization)

  // The snippet above is a factorial calculation without memoization.
  // It performs computation in every step, which can be seen on the console
  // outputs, on the second call its confirm the recomputation

  // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

  // Let's make new calls but using the Class FactorialMemoiz that is
  // implemented using the memoization

  val factMem = new FactorialMemoiz()

  println(factMem.calcFactMemoiz(3))
  // Performing calculation 3 (with memoization)
  // Performing calculation 2 (with memoization)
  // 6

  println(factMem.calcFactMemoiz(5))
  // Performing calculation 5 (with memoization)
  // Performing calculation 4 (with memoization)
  // Performing lookup 3
  // 120

  // Now, let's understand the console output, on the first call the value is 3
  // since the cache is empty, it will entered to the calculation block twice
  // for 3 and 2, after all the calculations is done it return and print the
  // factorial value that is 6.
  // Then we call with the value 5 so it will entered to the calculation block
  // twice for 5 and 4, after it will get the precomputed value for 3 so we can
  // see one lookup block execution and then return and print the factorial
  // value that is 120.
}

class FactorialMemoiz {
  var cache = Map.empty[Int, Int]

  def lookup(num: Int): Int =
    cache.getOrElse(num, 0)

  def calcFactMemoiz(x: Int): Int = {
    if (x == 0 || x == 1) 1
    else if (lookup(x) > 0) {
      println(s"Performing lookup $x")
      lookup(x)
    } else {
      println(s"Performing calculation $x (with memoization)")
      val factorial = x * calcFactMemoiz(x - 1)
      cache += x -> factorial
      factorial
    }
  }
}
