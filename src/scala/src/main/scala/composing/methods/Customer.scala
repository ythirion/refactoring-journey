package org.ythirion.refactoring.journey
package composing.methods

class Customer(val name: String, val age: Int) {
  override def toString: String = s"Customer{name='$name', age=$age}"
}