package it.chicio.scalawithcats.chapter4

import cats.data.State
import cats.syntax.applicative._

object PostOrderCalculator {
  type CalcState[A] = State[List[Int], A]

  def evalOne(sym: String): CalcState[Int] = {
    sym match {
      case "+" => manage((a, b) => a + b)
      case "-" => manage(_ - _)
      case "*" => manage(_ * _)
      case "/" => manage(_ / _)
      case num => manage(num.toInt)
    }
  }

  def evalAll(input: List[String]): CalcState[Int] = {
    input.foldLeft(0.pure[CalcState]) {
      (previousResult: CalcState[Int], currentElement: String) =>
        previousResult.flatMap((result: Int) => evalOne(currentElement))
    }
  }

  def manage(number: Int): State[List[Int], Int] = State[List[Int], Int] {
    numbers => (numbers :+ number, number)
  }

  def manage(operation: (Int, Int) => Int): CalcState[Int] = State[List[Int], Int] { symbols =>
    val numbers = symbols.takeRight(2)
    (symbols.dropRight(2), operation(numbers(0), numbers(1)))
  }
}

object PostOrderCalculatorApp extends App {
  val program = for {
    _   <- PostOrderCalculator.evalOne("1")
    _   <- PostOrderCalculator.evalOne("2")
    ans <- PostOrderCalculator.evalOne("+")
  } yield ans

  println(program.runA(Nil).value)

  val anotherProgram = PostOrderCalculator.evalAll(List("1", "2", "+", "3", "*"))
  println(anotherProgram.runA(Nil).value)
}