//> using scala "3.3.1"

import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import concurrent.ExecutionContext.Implicits.global

object SequenceAndTraverse extends App {

  def work(startTime: Int, workName: String, sleepTime: Int = 1000): Future[Unit] = Future {
    Thread.sleep(sleepTime)
    val time       = System.currentTimeMillis.toInt - startTime
    val threadName = Thread.currentThread.getName
    println(s"[$workName] time: $time ms, thread: $threadName")
  }

  def futureListGenerator(count: Int, name: String, startTime: Int): List[Future[Unit]] = {
    (1 to count).map(i => work(startTime, s"$name#$i")).toList
  }

  def runFutureSequence(count: Int): Future[Unit] = {
    val name = "FutureSequence"
    println(s"\n[$name] start, count: $count")
    val startTime = System.currentTimeMillis.toInt
    val futures   = futureListGenerator(count, name, startTime)
    Future.sequence(futures).map(_ => println(s"[$name] $count works run"))
  }

  def runFutureTraverse(count: Int): Future[Unit] = {
    val name = "FutureTraverse"
    println(s"\n[$name] start, count: $count")
    val startTime = System.currentTimeMillis.toInt
    val futures   = futureListGenerator(count, name, startTime)
    Future.traverse(futures)(identity).map(_ => println(s"[$name] $count works run"))
  }

  def runManualSequentially(count: Int): Future[Unit] = {
    val name = "ManualSequentially"
    println(s"\n[$name] start, count: $count")
    val startTime = System.currentTimeMillis.toInt
    val futures = (1 to count).foldLeft(Future.successful(List.empty[Unit])) { (acc, i) =>
      acc.flatMap(_ => work(startTime, s"$name#$i").map(_ :: Nil))
    }
    futures.map(_ => println(s"[$name] $count works run"))
  }

  Await.result(runFutureSequence(5), 10.seconds)
  Await.result(runFutureTraverse(5), 10.seconds)
  Await.result(runManualSequentially(5), 10.seconds)
}
