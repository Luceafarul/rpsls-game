package com.example.domain

import io.circe.{Encoder, Decoder}
import io.circe.generic.semiauto._

final case class Guest(name: String)

object Guest {
  implicit val guestEncoder: Encoder[Guest] = deriveEncoder[Guest]
  implicit val guestDecoder: Decoder[Guest] = deriveDecoder[Guest]
}
