package it.chicio.scalawithcats.chapter1.printablelibrary

object PrintableInstances {
  implicit val printableString: PrintableTypeClass[String] = (value: String) => value
  implicit val printableInt: PrintableTypeClass[Int] = (value: Int) => value.toString
}