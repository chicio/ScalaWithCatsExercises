package it.chicio.scalawithcats.chapter1

import PrintableInstances._
import PrintableSyntax._
import cats.implicits._
import ShowableInstances._

object PrintableLibrary extends App {
  Printable.print(1)
  Printable.print("Scala dragon")
  Printable.print(Cat("Ciro", 10, "Gray"))
  val cat = Cat("Piro", 11, "Black")
  cat.print

  //Using cats show
  println(cat.show)
}
