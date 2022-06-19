package com.example.services

import cats.effect.IO
import java.util.UUID
import com.example.domain.PlayerId

object UUIDService {
  def generateId: IO[PlayerId] =
    IO(PlayerId(UUID.randomUUID.toString))
}
