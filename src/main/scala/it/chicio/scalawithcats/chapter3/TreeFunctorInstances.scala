package it.chicio.scalawithcats.chapter3

import cats.{Functor, Show}

object TreeFunctorInstance {
  implicit val treeFunctor = new Functor[Tree] {
    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = {
      fa match {
        case Branch(left, right) =>
          Branch(map(left)(f), map(right)(f))
        case Leaf(value) =>
          Leaf(f(value))
      }
    }
  }

  implicit def treeShow[A](implicit showable: Show[A]) = new Show[Tree[A]] {
    override def show(tree: Tree[A]): String =
      tree match {
        case Branch(left, right) =>
          show(left) + " - " + show(right)
        case Leaf(value: A) =>
          showable.show(value)
      }
  }
}