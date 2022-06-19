package com.example.game

import cats.effect.{ExitCode, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    GameServer.stream.compile.drain.as(ExitCode.Success)
}
