package dealing.`with`.generalization

final case class JumpyAthlete(name: String, logger: BusinessLogger) {
  def swim(): Unit = logger.log(s"$name started swimming")

  def cycle(): Unit = logger.log(s"$name started cycling")

  def run(): Unit = logger.log(s"$name started running")

  def jump(): Unit = logger.log(s"$name is skydiving")
}
