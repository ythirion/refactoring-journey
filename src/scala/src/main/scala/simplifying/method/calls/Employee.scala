package org.ythirion.refactoring.journey
package simplifying.method.calls

import java.util.UUID

class Employee(val name: String,
               val role: String,
               val currentProject: String,
               val skills: List[String]) {
  lazy val id: String = UUID.randomUUID.toString

  def get: String = id

  def getN: String = name

  def getR: String = role

  def getP: String = currentProject

  def isProfessionalService: Boolean = !(getR == "Assoc")

  def isIdeal: Boolean = getP == "Beach" || getP.isEmpty

  def hasSomething(skill: String): Boolean = skills.contains(skill)
}
