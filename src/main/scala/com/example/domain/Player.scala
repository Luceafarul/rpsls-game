package com.example.domain

import io.circe.{Encoder, Decoder}
import io.circe.generic.semiauto._

final case class PlayerId(id: String)
object PlayerId {
  implicit val playerIdEncoder: Encoder[PlayerId] = deriveEncoder[PlayerId]
  implicit val playerIdDecoder: Decoder[PlayerId] = deriveDecoder[PlayerId]
}

final case class Player(id: PlayerId, name: String)
object Player {
  implicit val playerEncoder: Encoder[Player] = deriveEncoder[Player]
  implicit val playerDecoder: Decoder[Player] = deriveDecoder[Player]
}
