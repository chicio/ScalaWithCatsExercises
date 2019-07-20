package it.chicio.scalawithcats.chapter3

object CodecImapInstances {
  implicit val stringCodec: Codec[String] = new Codec[String] {
    def encode(value: String): String = value
    def decode(value: String): String = value
  }

  implicit val intCodec: Codec[Int] = stringCodec.imap(_.toInt, _.toString)

  implicit val booleanCodec: Codec[Boolean] = stringCodec.imap(_.toBoolean, _.toString)

  implicit val doubleCodec: Codec[Double] = stringCodec.imap(_.toDouble, _.toString)

  implicit def boxCodec[A](implicit codec: Codec[A]): Codec[Box[A]] = codec.imap(value => Box(value), box => box.value)
}
