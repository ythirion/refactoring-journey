package dealing.`with`.generalization

trait Run extends Athlete {
  def run(): Unit = logger.log(s"$name started running")
}
