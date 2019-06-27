package it.chicio.scalawithcats.chapter2

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

object Semigroup {
  def apply[A](implicit semigroup: Semigroup[A]) = semigroup
}