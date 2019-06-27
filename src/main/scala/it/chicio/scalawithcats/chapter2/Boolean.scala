package it.chicio.scalawithcats.chapter2

object BooleanInstances {
  implicit val and = new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  implicit val or = new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(x: Boolean, y: Boolean): Boolean = x || y
  }

  implicit val xor = new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(x: Boolean, y: Boolean): Boolean = x ^ y
  }

  implicit val xnor = new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(x: Boolean, y: Boolean): Boolean = x == y
  }
}

object Boolean extends App {
  //AND
  println(Monoid(BooleanInstances.and).combine(true, true))
  println(Monoid(BooleanInstances.and).combine(true, false))
  println(Monoid(BooleanInstances.and).combine(false, true))
  println(Monoid(BooleanInstances.and).combine(false, false))

  //OR
  println(Monoid(BooleanInstances.or).combine(true, true))
  println(Monoid(BooleanInstances.or).combine(true, false))
  println(Monoid(BooleanInstances.or).combine(false, true))
  println(Monoid(BooleanInstances.or).combine(false, false))

  //XOR
  println(Monoid(BooleanInstances.xor).combine(true, true))
  println(Monoid(BooleanInstances.xor).combine(true, false))
  println(Monoid(BooleanInstances.xor).combine(false, true))
  println(Monoid(BooleanInstances.xor).combine(false, false))

  //XNOR
  println(Monoid(BooleanInstances.xnor).combine(true, true))
  println(Monoid(BooleanInstances.xnor).combine(true, false))
  println(Monoid(BooleanInstances.xnor).combine(false, true))
  println(Monoid(BooleanInstances.xnor).combine(false, false))
}
