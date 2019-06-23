package it.chicio.scalawithcats.chapter1.printablelibrary

object PrintableInstances {
  implicit val printableString: Printable[String] = (value: String) => value
  implicit val printableInt: Printable[Int] = (value: Int) => value.toString
  implicit val printableCat: Printable[Cat] = (value: Cat) => Printable.format(value.name) + " is a " +
                                                              Printable.format(value.age) + " year-old " +
                                                              Printable.format(value.color) + " cat."
}