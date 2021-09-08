package dealing.`with`.generalization

final case class TriAthlete(name: String, logger: BusinessLogger) {
  def swim(): Unit = logger.log(s"$name started swimming")

  def cycle(): Unit = logger.log(s"$name started cycling")

  def run(): Unit = logger.log(s"$name started running")
}
