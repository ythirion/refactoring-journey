package moving.features

final case class Team(name: String, league: League) {
  val country: String = league.country
}
