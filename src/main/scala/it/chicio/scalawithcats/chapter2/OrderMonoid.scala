package it.chicio.scalawithcats.chapter2

import cats.instances.double._
import cats.syntax.monoid._

object OrderMonoid {
  implicit val orderMonoid = new cats.Monoid[Order] {
    override def empty: Order = Order(0, 0)
    override def combine(x: Order, y: Order): Order = new Order(
      y.totalCost |+| y.totalCost,
      x.quantity |+| y.quantity
    )
  }
}