package it.chicio.scalawithcats.chapter2

import cats.syntax.show._
import cats.syntax.monoid._
import cats.instances.int._
import cats.instances.option._
import it.chicio.scalawithcats.chapter2.OrderMonoid._

case class Order(totalCost: Double, quantity: Double)

class SuperAdder[T] {
  def add(items: List[T])(implicit monoid: cats.Monoid[T]): T = items.fold(monoid.empty)((sum, element) => sum |+| element)
}

object SuperAdderMain extends App {
  println(new SuperAdder[Int]().add(List(1, 2, 3, 4)).show)
  println(new SuperAdder[Option[Int]]().add(List(Option(1), Option(2), Option(3), Option(4), Option(5))))
  println(new SuperAdder[Order]().add(List(Order(10, 1), Order(10, 2))))
}
