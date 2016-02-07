package pl.linux.platinum.phisikus.cube

import org.scalatest.FlatSpec

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCubeTest extends FlatSpec {
  "RubiksCube" should " be created properly" in {
    val cube = new RubiksCube()
    println(cube.toString)
    assert(true)
  }
}
