package scala.pl.linux.platinum.phisikus.cube.transformations

import _root_.pl.linux.platinum.phisikus.cube.transformations.RubiksCubeTransformer
import _root_.pl.linux.platinum.phisikus.cube.{Cube, RubiksCube}
import org.scalatest.FlatSpec

/**
  * Created by phisikus on 10.02.16.
  */
class RubiksCubeTransformerTest extends FlatSpec {

  "RubiksCubeTransformer" should "properly turn columns" in {
    val size = 10
    val cube = new RubiksCube(size)
    var transformedCube: Cube = cube
    val transformer = new RubiksCubeTransformer

    for (j <- 0 to 3) {
      for (i <- 0 to size - 1) {
        transformedCube = transformer.turnColumn(i, true, transformedCube)
      }
    }
    assert(cube == transformedCube)

    for (i <- 0 to size - 1) {
      transformedCube = transformer.turnColumn(i, true, transformedCube)
    }

    for (i <- 0 to size - 1) {
      transformedCube = transformer.turnColumn(i, false, transformedCube)
    }

    assert(cube == transformedCube)


  }

  "RubiksCubeTransformer" should "properly turn rows" in {
    val size = 10
    val cube = new RubiksCube(size)
    var transformedCube: Cube = cube
    val transformer = new RubiksCubeTransformer

    for (j <- 0 to 3) {
      for (i <- 0 to size - 1) {
        transformedCube = transformer.turnRow(i, true, transformedCube)
      }
    }
    assert(cube == transformedCube)

    for (i <- 0 to size - 1) {
      transformedCube = transformer.turnRow(i, true, transformedCube)
    }

    for (i <- 0 to size - 1) {
      transformedCube = transformer.turnRow(i, false, transformedCube)
    }

    assert(cube == transformedCube)
  }

  "RubiksCubeTransformer" should "properly turn rows and columns combined" in {
    val size = 10
    val cube = new RubiksCube(size)
    var transformedCube: Cube = cube
    val transformer = new RubiksCubeTransformer

    for (i <- 0 to size - 1) {
      transformedCube = transformer.turnRow(i, false, transformedCube)
      transformedCube = transformer.turnColumn(i, true, transformedCube)
    }


    for (i <- (size - 1) to 0 by -1) {
      transformedCube = transformer.turnColumn(i, false, transformedCube)
      transformedCube = transformer.turnRow(i, true, transformedCube)
    }


    assert(cube == transformedCube)
    assert(transformedCube.isSolved)
  }


}
