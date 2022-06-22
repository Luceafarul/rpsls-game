package com.example.services

import java.util.UUID
import com.example.domain.PlayerId

object UUIDService {
  def generateId: PlayerId = PlayerId(UUID.randomUUID.toString)
}
