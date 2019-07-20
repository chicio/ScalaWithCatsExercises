package it.chicio.scalawithcats.chapter4

import cats.Eval


object SafeFolding {
  def foldRight[A, B](as: List[A], acc: B)(fn: (A, Eval[B]) => Eval[B]): Eval[B] = as match {
    case head :: tail =>
      fn(head, Eval.defer(foldRight(tail, acc)(fn)))
    case Nil =>
      Eval.now(acc)
  }
}