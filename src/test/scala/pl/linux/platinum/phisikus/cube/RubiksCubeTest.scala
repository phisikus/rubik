package pl.linux.platinum.phisikus.cube

import org.scalatest.FlatSpec
import pl.linux.platinum.phisikus.cube.cubies.CubieColor
import pl.linux.platinum.phisikus.cube.sides.RubiksCubeSide

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCubeTest extends FlatSpec {
  "RubiksCube" should " be created properly" in {
    val cube = new RubiksCube()
    val cubeToCompare = new RubiksCube(new RubiksCubeSide(CubieColor.WHITE),
      new RubiksCubeSide(CubieColor.YELLOW),
      new RubiksCubeSide(CubieColor.ORANGE),
      new RubiksCubeSide(CubieColor.RED),
      new RubiksCubeSide(CubieColor.BLUE),
      new RubiksCubeSide(CubieColor.GREEN))
    assert(cubeToCompare == cube)
  }

  "RubiksCube" should " have a correct comparasion function" in {
    val cube = new RubiksCube()
    val cubeToCompare = new RubiksCube(new RubiksCubeSide(CubieColor.WHITE),
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.ORANGE),
      new RubiksCubeSide(CubieColor.RED),
      new RubiksCubeSide(CubieColor.BLUE),
      new RubiksCubeSide(CubieColor.RED))
    assert(cubeToCompare != cube)
  }

  "RubiksCube" should "be created properly from List of sides" in {
    val sides = List(
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN)
    )
    val cube = new RubiksCube(sides)
    val cubeToCompare = new RubiksCube(new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN),
      new RubiksCubeSide(CubieColor.GREEN))

    assert(cube == cubeToCompare)
  }
}
