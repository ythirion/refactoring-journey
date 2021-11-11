package moving.features

import scala.util.Properties.lineSeparator

final case class ChampionsLeague(teams: List[Team]) {
  def nextStageTable: String =
    teams
      .map(team => s"${team.name} - ${team.league.country}")
      .mkString(lineSeparator)
}
