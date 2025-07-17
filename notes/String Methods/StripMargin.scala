/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * The stripMargin method is a method that allows us to format multiline strings
 * in a more readable way. It removes the leading spaces in each line of the
 * string. The default character used to remove the spaces is the pipe character
 * (|), but we can specify a different character if we want.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: Programming in Scala, Fifth Edition by Martin Odersky
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object StripMargin extends App {
  val text = """This is a multiline text
                that we can format
                using the stripMargin method."""

  println(text)
  // This is a multiline text
  //               that we can format
  //               using the stripMargin method.

  val textFormatted = """This is a multiline text
                        |that we can format
                        |using the stripMargin method.""".stripMargin

  println(textFormatted)
  // This is a multiline text
  // that we can format
  // using the stripMargin method.
}
