package it.chicio.scalawithcats.chapter3

import CodecImapInstances._

object CodecImap extends App {
  println(Codec.encode("a string"))
  println(Codec.encode(1.2))
  println(Codec.decode[Double]("1.2"))
  println(Codec.encode(Box(1.2)))
  println(Codec.decode[Box[Double]]("1.2"))
}