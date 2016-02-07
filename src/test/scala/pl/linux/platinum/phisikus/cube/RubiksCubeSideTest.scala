package pl.linux.platinum.phisikus.cube

import org.scalatest.FlatSpec
import pl.linux.platinum.phisikus.cube.cubies.{CubieColor, StandardCubie}
import pl.linux.platinum.phisikus.cube.sides.RubiksCubeSide

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
    val elementsAndSides = CubieColor.values.map(color => (generateListOfTestElements(color), new RubiksCubeSide(color)))
    elementsAndSides.map { case (x, y) => assert(x == y.elements) }
  }
}