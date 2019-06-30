package it.chicio.scalawithcats.chapter3

trait EnhancedPrintable[A] {
  def format(value: A): String
  def contramap[B](func: B => A): EnhancedPrintable[B] = (value: B) => format(func(value))
}

object EnhancedPrintable {
  def format[A](value: A)(implicit enhancedPrintable: EnhancedPrintable[A]): String = enhancedPrintable.format(value)
  def contramap[A, B](func: B => A)(implicit enhancedPrintable: EnhancedPrintable[A]): EnhancedPrintable[B] = (value: B) => format(func(value))
}