package it.chicio.scalawithcats.chapter1

import cats.Eq
import cats.syntax.eq._
import cats.instances.int._
import cats.instances.string._

object EqInstances {
  implicit val catShow: Eq[Cat] = Eq.instance[Cat]{ (cat1, cat2) =>
    cat1.name === cat2.name &&
    cat1.color === cat2.color &&
    cat1.age === cat2.age
  }
}
