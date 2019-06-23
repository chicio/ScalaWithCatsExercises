package it.chicio.scalawithcats.chapter1.printablelibrary

import cats._
import cats.implicits._

object ShowableInstances {
  implicit val catShow: Show[Cat] = (value: Cat) => value.name.show + " is a " +
                                                    value.age.show + " year-old " +
                                                    value.color.show + " cat."
}
