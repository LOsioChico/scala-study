/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * String Interpolators are a way to embed expressions in a string. We can use
 * the s interpolator to embed expressions in a string. We can also use the f
 * interpolator to format numbers in a string. The raw interpolator is used to
 * avoid escaping characters in a string.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference:
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object StringInterpolators extends App {
  println(s"The answer is ${6 * 7}.") // <- The answer is 42.

  println(raw"No\\\\escape!") // <- No\\\\escape!

  println(f"${math.Pi}%.5f") // <- 3.14159
}
