package it.chicio.scalawithcats.chapter3

import TreeFunctorInstance._
import cats.syntax.functor._
import cats.syntax.show._
import cats.instances.int._

sealed trait Tree[+A]
final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]

///Very hard to get it work.
///See https://stackoverflow.com/questions/48545028/why-can-find-functor-instance-for-tree-but-not-for-branch-or-leaf
object Tree {
  def branch[A](left: Tree[A], right: Tree[A]): Tree[A] = Branch(left, right)
  def leaf[A](value: A): Tree[A] = Leaf(value)
}

object TreeFunctor extends App {
  println(Tree.branch(Tree.leaf(30), Tree.leaf(10)).map(element => element * 2).show)
}