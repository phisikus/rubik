package pl.linux.platinum.phisikus.cube.transformations

import pl.linux.platinum.phisikus.cube.cubies.Cubie
import pl.linux.platinum.phisikus.cube.sides.{CubeSide, RubiksCubeSide}
import pl.linux.platinum.phisikus.cube.{Cube, RubiksCube}

/**
  * Created by phisikus on 10.02.16.
  */
class RubiksCubeTransformer extends Transformer {


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

  override def turnSide(position: Integer, clockWise: Boolean, cube: Cube): Cube = {
    clockWise match {
      case true => turnSideClockWise(position, cube)
      case false => turnSideCounterClockWise(position, cube)
    }
  }


  private def turnSideClockWise(position: Integer, cube: Cube): Cube = {
    val westSide = getCubeSideReplaceColumn(cube.size - 1 - position, cube.bottom.getRow(position), cube.west.elements)
    val topSide = getCubeSideReplaceRow(cube.size - 1 - position, cube.west.getColumn(cube.size - 1 - position).reverse, cube.top.elements)
    val eastSide = getCubeSideReplaceColumn(position, cube.top.getRow(cube.size - 1 - position), cube.east.elements)
    val bottomSide = getCubeSideReplaceRow(position, cube.east.getColumn(position).reverse, cube.bottom.elements)
    var northSide = cube.north
    var southSide = cube.south

    if (position == 0) {
      southSide = turnSouthSide(true, cube.south)
    }
    if (position == (cube.size - 1)) {
      northSide = turnNorthSide(true, cube.north)
    }
    new RubiksCube(topSide, bottomSide, northSide, southSide, eastSide, westSide)
  }

  private def turnSouthSide(clockWise: Boolean, cubeSide: CubeSide): CubeSide = {
    clockWise match {
      case true => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedRight(cubeSide.elements))
      case false => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedLeft(cubeSide.elements))
    }
  }

  private def turnNorthSide(clockWise: Boolean, cubeSide: CubeSide): CubeSide = {
    clockWise match {
      case false => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedRight(cubeSide.elements))
      case true => new RubiksCubeSide(CubieMatrixHelper.getMatrixOfCubiesTurnedLeft(cubeSide.elements))
    }
  }


  private def turnSideCounterClockWise(position: Integer, cube: Cube): Cube = {
    val westSide = getCubeSideReplaceColumn(cube.size - 1 - position, cube.top.getRow(cube.size - 1 - position).reverse, cube.west.elements)
    val topSide = getCubeSideReplaceRow(cube.size - 1 - position, cube.east.getColumn(position), cube.top.elements)
    val eastSide = getCubeSideReplaceColumn(position, cube.bottom.getRow(position).reverse, cube.east.elements)
    val bottomSide = getCubeSideReplaceRow(position, cube.west.getColumn(cube.size - 1 - position), cube.bottom.elements)
    var northSide = cube.north
    var southSide = cube.south

    if (position == 0) {
      southSide = turnSouthSide(false, cube.south)
    }
    if (position == (cube.size - 1)) {
      northSide = turnNorthSide(false, cube.north)
    }
    new RubiksCube(topSide, bottomSide, northSide, southSide, eastSide, westSide)
  }


}
