package dealing.`with`.generalization

final case class TriAthlete(name: String, logger: BusinessLogger)
    extends Cycle
    with Run
    with Swim
