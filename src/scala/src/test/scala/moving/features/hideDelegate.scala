package org.ythirion.refactoring.journey
package moving.features

import org.scalatest.funsuite.AnyFunSuite

class hideDelegate extends AnyFunSuite {
  val liga = League("Spain")
  val premierLeague = League("England")
  val ligue1 = League("France")
  val bundesliga = League("German")
  val ligaNos = League("Portugal")
  val serieA = League("Italy")

  val championsLeague2020 = ChampionsLeague(List(
    Team("FC Barcelone", liga),
    Team("PSG", ligue1),
    Team("RB Leipzig", bundesliga),
    Team("FC Liverpool", premierLeague),
    Team("Seville FC", liga),
    Team("Borussia Dortmund", bundesliga),
    Team("FC Porto", ligaNos),
    Team("Juventus Turin", serieA),
    Team("Lazio Rome", serieA),
    Team("Bayern Münich", bundesliga),
    Team("Atletic de Madrid", liga),
    Team("Chelsea", premierLeague),
    Team("Atalanta Bergame", serieA),
    Team("Real Madrid", liga),
    Team("Borussia M'Gladbach", bundesliga),
    Team("Manchester City", premierLeague)));

  test("") {
    assert(championsLeague2020.nextStageTable ==
      """FC Barcelone - Spain
        |PSG - France
        |RB Leipzig - German
        |FC Liverpool - England
        |Seville FC - Spain
        |Borussia Dortmund - German
        |FC Porto - Portugal
        |Juventus Turin - Italy
        |Lazio Rome - Italy
        |Bayern Münich - German
        |Atletic de Madrid - Spain
        |Chelsea - England
        |Atalanta Bergame - Italy
        |Real Madrid - Spain
        |Borussia M'Gladbach - German
        |Manchester City - England""".stripMargin)
  }
}