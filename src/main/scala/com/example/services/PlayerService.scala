package com.example.services

import com.example.domain.Player
import com.example.domain.Guest
import com.example.store.Store

final case class PlayerService(store: Store) {
  def createPlayer(guest: Guest): Player = {
    val p = Player(UUIDService.generateId, guest.name)
    store.add(p)
    p
  }

  def allPlayers = store.all
}
