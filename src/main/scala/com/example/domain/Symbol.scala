package com.example.domain

sealed trait Symbol {
  protected def beats: List[Symbol]

  def wins(that: Symbol): Boolean = beats.contains(that)
}

object Symbol {

  // Rock crushes Lizard
  // Rock crushes Scissors
  case object Rock extends Symbol {
    protected val beats: List[Symbol] = List(Lizard, Scissors)
  }

  // Paper covers Rock
  // Paper disproves Spock
  case object Paper extends Symbol {
    protected val beats: List[Symbol] = List(Rock, Spock)
  }

  // Scissors cuts Paper
  // Scissors decapitates Lizard
  case object Scissors extends Symbol {
    protected val beats: List[Symbol] = List(Paper, Lizard)
  }

  // Lizard poisons Spock
  // Lizard eats Paper
  case object Lizard extends Symbol {
    protected val beats: List[Symbol] = List(Spock, Paper)
  }

  // Spock smashes Scissors
  // Spock vaporizes Rock
  case object Spock extends Symbol {
    protected val beats: List[Symbol] = List(Scissors, Rock)
  }
}
