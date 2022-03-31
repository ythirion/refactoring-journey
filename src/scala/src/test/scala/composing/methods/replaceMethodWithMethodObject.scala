package composing.methods

import org.scalatest.funsuite.AnyFunSuite

class replaceMethodWithMethodObject extends AnyFunSuite {
  private val warehouse = Warehouse(
    9,
    Map(
      Product("Iphone 12", 989) -> 568,
      Product("Super Mario 3D World", 59.67) -> 98,
      Product("Blu Ray Avengers End Game", 28.99) -> 568,
      Product("Liverpool FC T-Shirt", 68) -> 78
    )
  )

  test("generate stock report") {
    assert(
      warehouse.generate(StockReportGenerator.generate) ==
        """Report for warehouse : 9
        |Product: Iphone 12 Price: 989.0 Stock : 568 units
        |Product: Super Mario 3D World Price: 59.67 Stock : 98 units
        |Product: Blu Ray Avengers End Game Price: 28.99 Stock : 568 units
        |Product: Liverpool FC T-Shirt Price: 68.0 Stock : 78 units
        |Total: 589369.98€""".stripMargin
    )
  }
}
