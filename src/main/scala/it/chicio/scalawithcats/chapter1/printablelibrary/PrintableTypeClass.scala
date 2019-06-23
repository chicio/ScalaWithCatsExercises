package it.chicio.scalawithcats.chapter1.printablelibrary

trait PrintableTypeClass[A] {
  def format(value: A): String
}