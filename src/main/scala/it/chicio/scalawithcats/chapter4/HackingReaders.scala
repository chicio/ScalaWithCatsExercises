package it.chicio.scalawithcats.chapter4

import cats.data.Reader
import cats.syntax.applicative._

final case class Db(usernames: Map[Int, String],passwords: Map[String, String])

object DbLogic {
  type DbReader[A] = Reader[Db, A]

  def findUsername(userId: Int): DbReader[Option[String]] = Reader(db => db.usernames.get(userId))

  def checkPassword(username: String, password: String): DbReader[Boolean] = Reader(db => db.passwords.get(username).contains(password))

  def checkLogin(userId: Int, password: String): DbReader[Boolean] = {
      findUsername(userId)
        .flatMap(username => username.map(validUserName => checkPassword(validUserName, password))
                                     .getOrElse(false.pure[DbReader])
        )
  }
}

object HackingReaders extends App {
  val users = Map(1 -> "dade", 2 -> "kate", 3 -> "margo")
  val passwords = Map("dade"  -> "zerocool", "kate"  -> "acidburn", "margo" -> "secret")
  val db = Db(users, passwords)

  println(DbLogic.checkLogin(1, "zerocool").run(db))
  println(DbLogic.checkLogin(4, "davinci").run(db))
}
