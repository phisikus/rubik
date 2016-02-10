package pl.linux.platinum.phisikus.cube.transformations

import pl.linux.platinum.phisikus.cube.cubies.Cubie
import pl.linux.platinum.phisikus.cube.sides.{CubeSide, RubiksCubeSide}
import pl.linux.platinum.phisikus.cube.{Cube, RubiksCube}

/**
  * Created by phisikus on 10.02.16.
  */
class RubiksCubeTransformer extends Transformer {


  /** It turns rubik's cube column.
    *
    * @param position  speficies which column should be moved (0 .. n-1)
    * @param clockWise clockwise rotation means movement from South side through Top to North side
    * @param cube      source object to transform
    * @return
    */
  override def turnColumn(position: Integer, clockWise: Boolean, cube: Cube): Cube = {
    clockWise match {
      case true => turnColumnClockWise(position, cube)
      case false => turnColumnCounterClockWise(position, cube)
    }
  }

  private def turnColumnClockWise(position: Integer, cube: Cube): Cube = {
    // column moves through Bottom -> South -> Top -> North (here n - i position)
    val northSide = getCubeSideReplaceColumn(cube.size - 1 - position, cube.top.getColumn(position), cube.north.elements)
    val bottomSide = getCubeSideReplaceColumn(position, cube.north.getColumn(cube.size - 1 - position), cube.bottom.elements)
    val southSide = getCubeSideReplaceColumn(position, cube.bottom.getColumn(position), cube.south.elements)
    val topSide = getCubeSideReplaceColumn(position, cube.south.getColumn(position), cube.top.elements)
    var eastSide = cube.east
    var westSide = cube.west

    if (position == 0) {
      westSide = turnWestSide(true, cube.west)
    }
    if (position == (cube.size - 1)) {
      eastSide = turnEastSide(true, cube.east)
    }

    new RubiksCube(topSide, bottomSide, northSide, southSide, eastSide, westSide)


  }

  private def getCubeSideReplaceColumn(position: Integer, column: Vector[Cubie], cubies: Vector[Vector[Cubie]]): CubeSide = {
    new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesReplaceColumn(position, column, cubies))
  }


  private def getCubeSideReplaceRow(position: Integer, row: Vector[Cubie], cubies: Vector[Vector[Cubie]]): CubeSide = {
    new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesReplaceRow(position, row, cubies))
  }

  private def turnColumnCounterClockWise(position: Integer, cube: Cube): Cube = {
    // column moves through North (n-i position) -> Top -> South -> Bottom
    val northSide = getCubeSideReplaceColumn(cube.size - 1 - position, cube.bottom.getColumn(position), cube.north.elements)
    val bottomSide = getCubeSideReplaceColumn(position, cube.south.getColumn(position), cube.bottom.elements)
    val southSide = getCubeSideReplaceColumn(position, cube.top.getColumn(position), cube.south.elements)
    val topSide = getCubeSideReplaceColumn(position, cube.north.getColumn(cube.size - 1 - position), cube.top.elements)
    var eastSide = cube.east
    var westSide = cube.west

    if (position == 0) {
      westSide = turnWestSide(false, cube.west)
    }
    if (position == (cube.size - 1)) {
      eastSide = turnEastSide(false, cube.east)
    }

    new RubiksCube(topSide, bottomSide, northSide, southSide, eastSide, westSide)


  }

  private def turnEastSide(clockWise: Boolean, cubeSide: CubeSide): CubeSide = {
    clockWise match {
      case true => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedRight(cubeSide.elements))
      case false => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedLeft(cubeSide.elements))
    }
  }


  private def turnWestSide(clockWise: Boolean, cubeSide: CubeSide): CubeSide = {
    clockWise match {
      case false => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedRight(cubeSide.elements))
      case true => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedLeft(cubeSide.elements))
    }
  }

  /** Turns rubik's cube row.
    *
    * @param position  speficies which column should be moved (0 .. n-1)
    * @param clockWise clockwise rotation means movement from West side through Top to East side
    * @param cube      source object to transform
    * @return
    */
  override def turnRow(position: Integer, clockWise: Boolean, cube: Cube): Cube = {
    clockWise match {
      case true => turnRowCounterClockWise(position, cube)
      case false => turnRowClockWise(position, cube)
    }
  }


  private def turnRowCounterClockWise(position: Integer, cube: Cube): Cube = {
    val westSide = getCubeSideReplaceRow(position, cube.north.getRow(position), cube.west.elements)
    val southSide = getCubeSideReplaceRow(position, cube.west.getRow(position), cube.south.elements)
    val eastSide = getCubeSideReplaceRow(position, cube.south.getRow(position), cube.east.elements)
    val northSide = getCubeSideReplaceRow(position, cube.east.getRow(position), cube.north.elements)
    var topSide = cube.top
    var bottomSide = cube.bottom

    if (position == 0) {
      topSide = turnTopSide(false, cube.top)
    }
    if (position == (cube.size - 1)) {
      bottomSide = turnBottomSide(false, cube.bottom)
    }
    new RubiksCube(topSide, bottomSide, northSide, southSide, eastSide, westSide)
  }

  private def turnTopSide(clockWise: Boolean, cubeSide: CubeSide): CubeSide = {
    clockWise match {
      case true => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedRight(cubeSide.elements))
      case false => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedLeft(cubeSide.elements))
    }
  }

  private def turnBottomSide(clockWise: Boolean, cubeSide: CubeSide): CubeSide = {
    clockWise match {
      case false => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedRight(cubeSide.elements))
      case true => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedLeft(cubeSide.elements))
    }
  }


  private def turnRowClockWise(position: Integer, cube: Cube): Cube = {
    val westSide = getCubeSideReplaceRow(position, cube.south.getRow(position), cube.west.elements)
    val southSide = getCubeSideReplaceRow(position, cube.east.getRow(position), cube.south.elements)
    val eastSide = getCubeSideReplaceRow(position, cube.north.getRow(position), cube.east.elements)
    val northSide = getCubeSideReplaceRow(position, cube.west.getRow(position), cube.north.elements)
    var topSide = cube.top
    var bottomSide = cube.bottom

    if (position == 0) {
      topSide = turnTopSide(true, cube.top)
    }
    if (position == (cube.size - 1)) {
      bottomSide = turnBottomSide(true, cube.bottom)
    }
    new RubiksCube(topSide, bottomSide, northSide, southSide, eastSide, westSide)
  }

}
