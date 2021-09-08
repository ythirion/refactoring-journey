package composing.methods

final case class Customer(name: String, age: Int) {
  override def toString: String = s"Customer{name='$name', age=$age}"
}
