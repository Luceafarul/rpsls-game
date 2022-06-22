package com.example.store

import com.example.domain.Player
import com.example.domain.PlayerId
import scala.collection.mutable.ArrayBuffer

final case class Store() {
  private val store = ArrayBuffer.empty[Player]

  def all: List[Player] = 
    store.toList

  def add(player: Player): List[Player] = 
    store.addOne(player).toList

  def delte(playerId: PlayerId): List[Player] =
    store.filterNot(_.id == playerId).toList
}
