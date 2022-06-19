package com.example.game

import cats.effect.{IO, Async, Resource}
import cats.syntax.all._
import com.comcast.ip4s._
import fs2.Stream
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import org.http4s.server.middleware.Logger
import com.example.game.GameRoutes

object GameServer {
  val stream: Stream[IO, Nothing] = {
    val routes = GameRoutes.routes.orNotFound
    val httpApp = Logger.httpApp(true, true)(routes)

    Stream.resource(
      EmberServerBuilder
        .default[IO]
        .withHost(ipv4"0.0.0.0")
        .withPort(port"8080")
        .withHttpApp(httpApp)
        .build >> Resource.eval(Async[IO].never)
    )
  }.drain
}
