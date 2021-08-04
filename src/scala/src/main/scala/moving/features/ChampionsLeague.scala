package org.ythirion.refactoring.journey
package moving.features

case class ChampionsLeague(teams: List[Team]) {
  def nextStageTable: String = teams.map(team => s"${team.name} - ${team.league.country}").mkString("\n")
}