package dealing.`with`.generalization

trait Run extends Athlete {
  def run(): Unit = logger.log(s"$name started running")
}

// Autre manière : force l'item qui étend ce trait a être un Athlete
trait Run2 { self: Athlete =>
  def run(): Unit = logger.log(s"$name started running")
}
