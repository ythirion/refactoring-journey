package org.ythirion.refactoring.journey
package moving.features

case class Team(name: String, league: League) {
  val country: String = league.country
}