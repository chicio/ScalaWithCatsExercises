package it.chicio.scalawithcats.chapter1

import cats.syntax.eq._
import cats.instances.option._
import EqInstances._

object Equality extends App {
  val cat1 = Cat("Garfield",   38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")
  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  println(cat1 === cat2)
  println(cat1 =!= cat2)
  println(optionCat1 === optionCat2)
  println(optionCat1 =!= optionCat2)
}
