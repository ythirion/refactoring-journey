package simplifying.method.calls

import java.util.UUID

final case class Employee(
    name: String,
    role: String,
    currentProject: String,
    skills: List[String]
) {
  private lazy val id: String = UUID.randomUUID.toString

  lazy val getId: String = id
  lazy val isWorking: Boolean = role != "Assoc"
  lazy val hasIdealJob: Boolean = currentProject == "Beach" || currentProject.isEmpty
  def isSkilledAt(skill: String): Boolean = skills.contains(skill)
}
