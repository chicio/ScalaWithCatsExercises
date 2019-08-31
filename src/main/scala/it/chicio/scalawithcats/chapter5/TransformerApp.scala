package it.chicio.scalawithcats.chapter5

import cats.data.EitherT
import cats.instances.future._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


object Transformer {
  val powerLevels: Map[String, Int] = Map(
    "Jazz"      -> 6,
    "Bumblebee" -> 8,
    "Hot Rod"   -> 10
  )

  type Response[A] = EitherT[Future, String, A]

  def getPowerLevel(ally: String): Response[Int] = {
    powerLevels.get(ally) match {
      case Some(avg) => EitherT.right(Future(avg))
      case None => EitherT.left(Future(s"$ally unreachable")) }
  }
}

object TransformerApp extends App {
  print(Transformer.getPowerLevel("Bumblebee"))
}
