package pl.linux.platinum.phisikus.cube.sides

import org.scalatest.FlatSpec
import pl.linux.platinum.phisikus.cube.cubies.{CubieColor, StandardCubie}

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCubeSideTest extends FlatSpec {

  protected def generateListOfTestElements(cubieColor: CubieColor.Value) = {
    List(
      List(new StandardCubie(cubieColor), new StandardCubie(cubieColor), new StandardCubie(cubieColor)),
      List(new StandardCubie(cubieColor), new StandardCubie(cubieColor), new StandardCubie(cubieColor)),
      List(new StandardCubie(cubieColor), new StandardCubie(cubieColor), new StandardCubie(cubieColor))
    )
  }

  "RubiksCubeSides" should "be created properly." in {
    val elementsAndSides = CubieColor.values.map(color => (generateListOfTestElements(color), new RubiksCubeSide(color, 3)))
    elementsAndSides.map { case (x, y) => assert(x == y.elements) }
  }

  "RubiksCubeSides" should "allow to extract specific rows and columns" in {
    val elements = List(
      List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW), new StandardCubie(CubieColor.RED)),
      List(new StandardCubie(CubieColor.WHITE), new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.ORANGE)),
      List(new StandardCubie(CubieColor.ORANGE), new StandardCubie(CubieColor.GREEN), new StandardCubie(CubieColor.WHITE))
    )
    val side = new RubiksCubeSide(elements)
    val firstColumn = elements.head
    val lastColumn = elements.last
    val firstRow = List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.WHITE), new StandardCubie(CubieColor.ORANGE))
    val lastRow = List(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.ORANGE), new StandardCubie(CubieColor.WHITE))
    assert(side.getColumn(0) == firstColumn)
    assert(side.getColumn(elements.size - 1) == lastColumn)
    assert(side.getRow(0) == firstRow)
    assert(side.getRow(elements.size - 1) == lastRow)
  }
}
