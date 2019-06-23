package it.chicio.scalawithcats.chapter1.printablelibrary

import PrintableInstances._
import PrintableSyntax._

object PrintableLibrary extends App {
  Printable.print(1)
  Printable.print("Scala dragon")
  Printable.print(Cat("Ciro", 10, "Gray"))
  val cat = Cat("Piro", 11, "Black")
  cat.print
}
