package com.example.game

import cats.effect.IO
import org.http4s._
import org.http4s.implicits._
import munit.CatsEffectSuite

import com.example.domain.Guest
import com.example.domain.Player

class GameRoutesSpec extends CatsEffectSuite {

  test("Root path returns status code 200") {
    assertIO(gameRouteRoot.map(_.status), Status.Ok)
  }

  test("Root path returns welcome message") {
    assertIO(gameRouteRoot.flatMap(_.as[String]), "Enter your name:")
  }

  // TODO: what should I do with implicits?
  import com.example.game.GameRoutes._

  test("Guest move to Lobby as Player") {
    assertIO(gameRouteLobby.flatMap(_.as[Player]).map(_.name), guest.name)
  }

  private val guest = Guest("Test")

  private[this] val gameRouteRoot: IO[Response[IO]] = {
    val root = Request[IO](Method.GET, uri"/")
    GameRoutes.routes.orNotFound(root)
  }

  private[this] val gameRouteLobby: IO[Response[IO]] = {
    val lobby = Request[IO](
      Method.POST,
      uri"/lobby",
      body = guestEncoder.toEntity(guest).body
    )
    GameRoutes.routes.orNotFound(lobby)
  }
}
