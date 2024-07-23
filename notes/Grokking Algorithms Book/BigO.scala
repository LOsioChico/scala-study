//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * EXERCISES
 * Give the run time for each of these scenarios in terms of Big O.
 *
 * 1.3 - You have a name, and you want to find the person’s phone number
 * in the phone book.
 * 1.4 - You have a phone number, and you want to find the person’s name
 * in the phone book. (Hint: You’ll have to search through the whole book!)
 * 1.5 - You want to read the numbers of every person in the phone book.
 * 1.6 - You want to read the numbers of just the As. (This is a tricky one!)
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Grokking Algorithms Illustrated Programmers Curious (Ch1)
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object BigO extends App {
  // 1.3
  // Using Binary Search we got O(log n)

  // 1.4
  // Assuming the phone book is a List, we got O(n)

  // 1.5
  // Assuming the phone book is a List, we got O(n) again

  // 1.6
  // The run time should be O(n) since we still need to iterate through all
  // the characters in the phone book to find the ones that start with 'A'.
}
