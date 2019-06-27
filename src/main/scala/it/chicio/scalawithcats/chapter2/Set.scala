package it.chicio.scalawithcats.chapter2


object SetInstances {
  implicit def union[A] = new Monoid[Set[A]] {
    override def empty: Set[A] = Set.empty
    override def combine(x: Set[A], y: Set[A]): Set[A] = x.union(y)
  }

  implicit def intersection[A] = new Semigroup[Set[A]] {
    override def combine(x: Set[A], y: Set[A]): Set[A] = x.intersect(y)
  }

  implicit def difference[A] = new Monoid[Set[A]] {
    override def empty: Set[A] = Set.empty[A]
    override def combine(x: Set[A], y: Set[A]): Set[A] = x.diff(y)
  }
}

object SetMain extends App {
  val set = Set(1, 2, 3, 4, 5)
  val anotherSet = Set(5, 6)

  println(Monoid[Set[Int]](SetInstances.union).combine(set, anotherSet))
  println(Semigroup[Set[Int]](SetInstances.intersection).combine(set, anotherSet))
  println(Monoid[Set[Int]](SetInstances.difference).combine(set, anotherSet))
}