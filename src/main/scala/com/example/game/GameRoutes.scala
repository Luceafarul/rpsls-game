package com.example.game

import org.http4s.circe._
import org.http4s.dsl.io._
import org.http4s.HttpRoutes
import cats.effect.IO
import com.example.domain.Player
import com.example.domain.Guest
import com.example.services.PlayerService

object GameRoutes {
  implicit val playerEncoder = jsonEncoderOf[IO, Player]
  implicit val playerDecoder = jsonOf[IO, Player]
  implicit val guestEncoder = jsonEncoderOf[IO, Guest]
  implicit val guestDecoder = jsonOf[IO, Guest]

  val routes = HttpRoutes.of[IO] {
    case GET -> Root => Ok("Enter your name:")
    case req @ POST -> Root / "lobby" =>
      for {
        guest <- req.as[Guest]
        player <- PlayerService.createPlayer(guest)
        resp <- Ok(player)
      } yield resp
  }
}
