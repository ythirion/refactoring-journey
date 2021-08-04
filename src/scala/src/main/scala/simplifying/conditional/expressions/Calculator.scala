package org.ythirion.refactoring.journey
package simplifying.conditional.expressions

object Calculator {
  def calculate(a: Int, b: Int, operator: String): Int = {
    var result = 0
    if ("add" == operator) result = a + b
    else if ("multiply" == operator) result = a * b
    else if ("divide" == operator) result = a / b
    else if ("subtract" == operator) result = a - b
    else throw new IllegalArgumentException("Not supported operator")
    result
  }
}