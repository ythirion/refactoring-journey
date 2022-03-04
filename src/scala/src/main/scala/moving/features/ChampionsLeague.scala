package moving.features

import scala.util.Properties.lineSeparator

final case class ChampionsLeague(teams: List[Team]) {
  lazy val nextStageTable: String =
    teams
      .map(team => s"${team.name} - ${team.country}")
      .mkString(lineSeparator)
}
