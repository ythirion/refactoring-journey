package dealing.`with`.generalization

final case class JumpyAthlete(name: String, logger: BusinessLogger)
    extends Swim
    with Run
    with Cycle
    with Jump
