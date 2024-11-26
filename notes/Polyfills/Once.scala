//> using scala "3.3.1"

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Creates a function that can be called only once. Subsequent calls return the
 * result of the first call.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object Once extends App {
  def once[T, R](fn: T => R): T => R = {
    var firstArg: Option[T] = None

    (arg: T) => {
      if (firstArg.isEmpty) firstArg = Some(arg)
      fn(firstArg.get)
    }
  }

  def sayHello(name: String): String = s"Hello, $name!"

  val sayHelloOnce = once(sayHello)

  println(sayHelloOnce("Alice")) // Output: "Hello, Alice!" (first call)
  println(sayHelloOnce("Bob"))   // Output: "Hello, Alice!" (subsequent calls)
}