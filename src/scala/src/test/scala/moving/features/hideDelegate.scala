package moving.features

import org.scalatest.funsuite.AnyFunSuite

class hideDelegate extends AnyFunSuite {
  private val liga = League("Spain")
  private val premierLeague = League("England")
  private val ligue1 = League("France")
  private val bundesliga = League("German")
  private val ligaNos = League("Portugal")
  private val serieA = League("Italy")

  private val championsLeague2020 = ChampionsLeague(
    List(
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
      Team("Manchester City", premierLeague)
    )
  )

  test("") {
    assert(
      championsLeague2020.nextStageTable ==
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
        |Manchester City - England""".stripMargin
    )
  }
}
