package it.chicio.scalawithcats.chapter4

import cats.data.Writer
import cats.instances.vector._
import cats.instances.string._
import cats.syntax.show._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

// In the book the author uses a little bit different approach
object WriterFactorial {
  def slowly[A](body: => A): A = try body finally Thread.sleep(100)

  def factorial(n: Int): Writer[Vector[String], Int] = {
    val ans: Writer[Vector[String], Int] = slowly(
      if(n == 0)
        Writer(Vector(), 1)
      else
        factorial(n - 1).mapBoth((log, nMinus1) => {
          val result = n * nMinus1
          (log :+ s"fact $n $result", result)
        })
    )
    ans
  }
}

object WriterFactorialMain extends App {
  val result: Vector[Writer[Vector[String], Int]] = Await.result(Future.sequence(Vector(
    Future(WriterFactorial.factorial(3)),
    Future(WriterFactorial.factorial(9))
  )), 5.seconds)

  println(result(0).written.show)
  println(result(1).written.show)
}
