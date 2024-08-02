//> using scala "3.3.1"

import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import concurrent.ExecutionContext.Implicits.global

/* 
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Reference: https://www.youtube.com/watch?v=y-rmSgCkBvg
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */

object FuturesV0 extends App {

  def work(startTime: Int, workName: String, sleepTime: Int = 1000): Future[Unit] = Future {
    Thread.sleep(sleepTime)
    println(s"workName: $workName, time: ${System.currentTimeMillis.toInt - startTime}ms")
  }

  def runSequentially(): Future[Unit] = {
    val startTime = System.currentTimeMillis.toInt

    for {
      _ <- work(startTime, "runSequentially1") // ≈ 1000ms
      _ <- work(startTime, "runSequentially2") // ≈ 2000ms
      _ <- work(startTime, "runSequentially3") // ≈ 3000ms
    } yield ()
  }

  def runParallelWaitingAll(): Future[Unit] = {
    val startTime = System.currentTimeMillis.toInt

    val f1 = work(startTime, "runParallelWaitingAll1")
    val f2 = work(startTime, "runParallelWaitingAll2")
    val f3 = work(startTime, "runParallelWaitingAll3")

    for {
      _ <- f1 // ≈ 1000ms
      _ <- f2 // ≈ 1000ms
      _ <- f3 // ≈ 1000ms
    } yield ()
  }

  // Potentially problems with "Forgetting" background processes
  // - Waste of resources (e.g. keeping a connection open)
  // - Might lead to resource starvation
  // - If a background process runs forever (e,g, message processor),
  // we can't easily stop it
  // - Can keep the JVM alive
  def runParallelForgetting(): Future[Unit] = {
    val startTime = System.currentTimeMillis.toInt

    val f1 = work(startTime, "runParallelForgetting1")
    val f2 = work(startTime, "runParallelForgetting2", 2000)
    val f3 = work(startTime, "runParallelForgetting3", 3000)

    for {
      _ <- f1 // ≈ 1000ms
    } yield ()
  }

  for {
    _ <- runSequentially()
    _ <- runParallelWaitingAll()
    _ <- runParallelForgetting()
  } yield ()

  Await.result(Future.never, 30.seconds)

}
