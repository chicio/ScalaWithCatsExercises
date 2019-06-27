package it.chicio.scalawithcats.chapter1

import cats.Show
import cats.instances.string._
import cats.instances.int._
import cats.syntax.show._

object ShowableInstances {
  implicit val catShow: Show[Cat] = (value: Cat) => value.name.show + " is a " +
                                                    value.age.show + " year-old " +
                                                    value.color.show + " cat."
}
