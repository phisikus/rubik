package pl.linux.platinum.phisikus.cube.sides

import org.scalatest.FlatSpec
import pl.linux.platinum.phisikus.cube.cubies.{CubieColor, StandardCubie}

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCubeSideTest extends FlatSpec {

  protected def generateVectorOfTestElements(cubieColor: CubieColor.Value) = {
    Vector(
      Vector(new StandardCubie(cubieColor), new StandardCubie(cubieColor), new StandardCubie(cubieColor)),
      Vector(new StandardCubie(cubieColor), new StandardCubie(cubieColor), new StandardCubie(cubieColor)),
      Vector(new StandardCubie(cubieColor), new StandardCubie(cubieColor), new StandardCubie(cubieColor))
    )
  }

  "RubiksCubeSides" should "be created properly." in {
    val elementsAndSides = CubieColor.values.map(color => (generateVectorOfTestElements(color), new RubiksCubeSide(color, 3)))
    elementsAndSides.map { case (x, y) => assert(x == y.elements) }
  }

  "RubiksCubeSides" should "allow to extract specific rows and columns" in {
    val elements = Vector(
      Vector(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.YELLOW), new StandardCubie(CubieColor.RED)),
      Vector(new StandardCubie(CubieColor.WHITE), new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.ORANGE)),
      Vector(new StandardCubie(CubieColor.ORANGE), new StandardCubie(CubieColor.GREEN), new StandardCubie(CubieColor.WHITE))
    )
    val side = new RubiksCubeSide(elements)
    val firstRow = elements.head
    val lastRow = elements.last
    val firstColumn = Vector(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.WHITE), new StandardCubie(CubieColor.ORANGE))
    val lastColumn = Vector(new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.ORANGE), new StandardCubie(CubieColor.WHITE))
    assert(side.getColumn(0) == firstColumn)
    assert(side.getColumn(elements.size - 1) == lastColumn)
    assert(side.getRow(0) == firstRow)
    assert(side.getRow(elements.size - 1) == lastRow)
  }
}
