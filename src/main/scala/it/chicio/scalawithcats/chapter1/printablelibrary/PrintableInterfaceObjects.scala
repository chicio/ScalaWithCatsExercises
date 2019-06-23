package it.chicio.scalawithcats.chapter1.printablelibrary

object Printable {
  def format[A](value: A)(implicit printable: PrintableTypeClass[A]): String = printable.format(value)
  def print[A](value: A)(implicit printable: PrintableTypeClass[A]): Unit = println(printable.format(value))
}