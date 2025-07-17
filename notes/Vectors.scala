/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Vector is an List alternative for very large set of data that has better
 * performance with no matter if we are performing operations on the beginning
 * middle, or end. This is because internally Vector is implemented using Trie
 * structures. Many operations in Vector are localized and hence give constant
 * time, O(1), performance.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Data Structures and Algorithms with Scala A Practitioners Approach
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object Vectors extends App {
  val myFruits = Vector("grape", "banana", "apple", "mango")
  println(myFruits) // <- Vector(grape, banana, apple, mango)

  // We can access to the indices like a List
  println(myFruits(3)) // <- mango

  val yourFruits = Vector("cucumber", "tomato")
  println(yourFruits) // <- Vector(cucumber, tomato)

  val combinedFruits = myFruits ++ yourFruits
  println(combinedFruits)
  // Vector(grape, banana, apple, mango, cucumber, tomato)

  val notQuiteFruits = combinedFruits.filter(_ == "tomato")
  println(notQuiteFruits) // <- Vector(tomato)

  // As we can see many of the higher level data manipualion operations are
  // available. When we filter for a particular elemento, it doesn't have
  // to traverse all the elements, notQuiteFruits in our case. The data are
  // stored in a Trie structure, which maintains pointer to the data in a
  // tree structure, that why it has a better performance.
}
