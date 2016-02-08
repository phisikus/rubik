package pl.linux.platinum.phisikus.cube

import org.scalatest.FlatSpec
import pl.linux.platinum.phisikus.cube.cubies.{CubieColor, StandardCubie}
import pl.linux.platinum.phisikus.cube.sides.RubiksCubeSide

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCubeTest extends FlatSpec {
  "RubiksCube" should " be created properly" in {
    val size = 3
    val cube = new RubiksCube(size)
    val cubeToCompare = new RubiksCube(new RubiksCubeSide(CubieColor.WHITE, size),
      new RubiksCubeSide(CubieColor.YELLOW, size),
      new RubiksCubeSide(CubieColor.ORANGE, size),
      new RubiksCubeSide(CubieColor.RED, size),
      new RubiksCubeSide(CubieColor.BLUE, size),
      new RubiksCubeSide(CubieColor.GREEN, size))
    assert(cubeToCompare == cube)
  }

  "RubiksCube" should " have a correct comparasion function" in {
    val size = 4
    val cube = new RubiksCube(size)
    val cubeToCompare = new RubiksCube(new RubiksCubeSide(CubieColor.WHITE, size),
      new RubiksCubeSide(CubieColor.GREEN, size),
      new RubiksCubeSide(CubieColor.ORANGE, size),
      new RubiksCubeSide(CubieColor.RED, size),
      new RubiksCubeSide(CubieColor.BLUE, size),
      new RubiksCubeSide(CubieColor.RED, size))
    assert(cubeToCompare != cube)
  }

  "RubiksCube" should "be created properly from List of sides" in {
    val sides = List(
      new RubiksCubeSide(CubieColor.GREEN, 5),
      new RubiksCubeSide(CubieColor.GREEN, 2),
      new RubiksCubeSide(CubieColor.GREEN, 1),
      new RubiksCubeSide(CubieColor.GREEN, 6),
      new RubiksCubeSide(CubieColor.GREEN, 3),
      new RubiksCubeSide(CubieColor.GREEN, 8)
    )
    val cube = new RubiksCube(sides)
    val cubeToCompare = new RubiksCube(new RubiksCubeSide(CubieColor.GREEN, 5),
      new RubiksCubeSide(CubieColor.GREEN, 2),
      new RubiksCubeSide(CubieColor.GREEN, 1),
      new RubiksCubeSide(CubieColor.GREEN, 6),
      new RubiksCubeSide(CubieColor.GREEN, 3),
      new RubiksCubeSide(CubieColor.GREEN, 8))

    assert(cube == cubeToCompare)
  }

  "RubiksCube" should "know when it's solved" in {
    val cube = new RubiksCube(4)
    assert(cube.isSolved)
  }

  "RubiksCube" should "know when it's solved even if it's not the default color arrangement" in {

    val size = 10
    val cube = new RubiksCube(new RubiksCubeSide(CubieColor.GREEN, size),
      new RubiksCubeSide(CubieColor.WHITE, size),
      new RubiksCubeSide(CubieColor.YELLOW, size),
      new RubiksCubeSide(CubieColor.ORANGE, size),
      new RubiksCubeSide(CubieColor.RED, size),
      new RubiksCubeSide(CubieColor.BLUE, size))
    assert(cube.isSolved)
  }

  "RubiksCube" should "know when it is not solved" in {
    val size = 3
    val cube = new RubiksCube(new RubiksCubeSide(CubieColor.GREEN, size),
      new RubiksCubeSide(CubieColor.WHITE, size),
      new RubiksCubeSide(CubieColor.YELLOW, size),
      new RubiksCubeSide(CubieColor.ORANGE, size),
      new RubiksCubeSide(CubieColor.RED, size),
      new RubiksCubeSide(List(
        List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.BLUE)),
        List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.BLUE)),
        List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.RED), new StandardCubie(CubieColor.BLUE))
      )))

    val secondCube = new RubiksCube(new RubiksCubeSide(CubieColor.GREEN, size),
      new RubiksCubeSide(CubieColor.WHITE, size),
      new RubiksCubeSide(CubieColor.YELLOW, size),
      new RubiksCubeSide(CubieColor.ORANGE, size),
      new RubiksCubeSide(CubieColor.RED, size),
      new RubiksCubeSide(List(
        List(new StandardCubie(CubieColor.YELLOW), new StandardCubie(CubieColor.YELLOW), new StandardCubie(CubieColor.YELLOW)),
        List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.BLUE)),
        List(new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.BLUE), new StandardCubie(CubieColor.BLUE))
      )))
    assert(!cube.isSolved)
    assert(!secondCube.isSolved)

  }

}
