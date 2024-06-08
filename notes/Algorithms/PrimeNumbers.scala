//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * A prime number is defined as a number that is only divisible by itself and
 * one, excluding 1.
 *
 * To know if a number is prime we can follow the next algorithm to know if the
 * number is compound:
 * 1. Check if the number is divisable by 2, 3 or 5. If the remainder is 0 then
 * the number is compound.
 * 2. Check if the sqrt of the number is exact, if yes then the number is
 * compound.
 * 3. Check if the number is divisable by a prime number lower than the sqrt
 * obtained, if yes then is compound.
 *
 * If after these steps the number is not compound, then the number is prime.
 *
 * Now, we can just avoid the first 2 steps and just try with the third one and
 * we will get the answer.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Data Structures and Algorithms with Scala A Practitioners Approach
 * https://www.youtube.com/watch?v=FnM-k0G8Zkg
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object PrimeNumbers extends App {
  val primes: LazyList[Int] = 2 #:: LazyList
    .from(3)
    .filter: num =>
      val primesLowerThanNumSqrt = primes.takeWhile(_ <= math.sqrt(num))
      !primesLowerThanNumSqrt.exists(prime => num % prime == 0)

  println(primes.take(15).toList)
  // List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47)
}
