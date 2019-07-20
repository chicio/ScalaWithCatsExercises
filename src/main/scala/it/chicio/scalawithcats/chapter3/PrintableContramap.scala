package it.chicio.scalawithcats.chapter3

import it.chicio.scalawithcats.chapter3.EnhancedPrintableInstances._

object PrintableContramap extends App {
  println(EnhancedPrintable.contramap[String, Int](element => element.toString).format(3))
  println(EnhancedPrintable.contramap[Int, Box[Int]](element => element.value).format(Box(2)))
  println(EnhancedPrintable.format(Box(10)))
  println(EnhancedPrintable.format(Box(true)))
  println(EnhancedPrintable.format(Box("La scatola")))
}
