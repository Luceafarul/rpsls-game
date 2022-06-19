package com.example.services

import com.example.domain.Player
import com.example.domain.Guest
import cats.effect.IO

object PlayerService {
  def createPlayer(guest: Guest): IO[Player] = 
    UUIDService.generateId.map(Player(_, guest.name))
}
