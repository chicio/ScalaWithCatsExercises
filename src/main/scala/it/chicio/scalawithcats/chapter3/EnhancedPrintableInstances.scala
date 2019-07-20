package it.chicio.scalawithcats.chapter3

object EnhancedPrintableInstances {
  implicit val printableString: EnhancedPrintable[String] = (value: String) => "\"" + value + "\""

  implicit val printableBoolean: EnhancedPrintable[Boolean] = (value: Boolean) => if(value) "yes" else "no"

  implicit val printableInt: EnhancedPrintable[Int] = (value: Int) => value.toString

  implicit def printableBox[A](implicit printer: EnhancedPrintable[A]): EnhancedPrintable[Box[A]] =
    (box: Box[A]) => printer.contramap[Box[A]](element => element.value).format(box)
}
