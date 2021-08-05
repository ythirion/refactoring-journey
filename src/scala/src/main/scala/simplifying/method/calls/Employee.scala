package org.ythirion.refactoring.journey
package simplifying.method.calls

import java.util.UUID

case class Employee(name: String,
                    role: String,
                    currentProject: String,
                    skills: List[String]) {
  private lazy val id: String = UUID.randomUUID.toString

  def getId: String = id
  def isWorking: Boolean = !(role == "Assoc")
  def hasIdealJob: Boolean = currentProject == "Beach" || currentProject.isEmpty
  def isSkilledAt(skill: String): Boolean = skills.contains(skill)
}
