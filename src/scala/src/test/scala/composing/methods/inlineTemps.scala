package org.ythirion.refactoring.journey
package composing.methods

import org.scalatest.funsuite.AnyFunSuite

class inlineTemps extends AnyFunSuite {
  /*
  private val faker: Faker = new Faker

    @Test  def deserveDiscount(): Unit =  { val orderDeservingDiscount: Order = Order.builder.products(new ArrayList[Product](List.of(Product.builder.name("Something expensive").price(1000.01).build))).build
val orderNotDeservingDiscount: Order = Order.builder.products(new ArrayList[Product](List.of(Product.builder.name("Something less expensive").price(1000).build))).build
assertThat(OrderHelper.deserveDiscount(orderDeservingDiscount)).isTrue
assertThat(OrderHelper.deserveDiscount(orderNotDeservingDiscount)).isFalse
}

    @Test  def deserveDiscountBasedOnCustomer(): Unit =  { val customer: Customer = Customer.builder.age(47).name("Robert Pires").build
val orderDeservingDiscount: Order = Order.builder.customer(customer).products(generateFakeProducts(12)).build
val orderNotDeservingDiscount: Order = Order.builder.customer(customer).products(generateFakeProducts(9)).build
assertThat(OrderHelper.deserveDiscountBasedOnCustomer(orderDeservingDiscount)).isTrue
assertThat(OrderHelper.deserveDiscountBasedOnCustomer(orderNotDeservingDiscount)).isFalse
}

    private def generateFakeProducts(times: Int): ArrayList[Product] =  { return Stream.iterate(0, (i: Integer) => i + 1).limit(times).map((i: Integer) => Product.builder.name(faker.commerce.productName).build).collect(Collectors.toCollection(ArrayList.`new`))
}
   */
}
