package pl.linux.platinum.phisikus.rubik.cube.transformations

import pl.linux.platinum.phisikus.rubik.cube.cubies.Cubie
import pl.linux.platinum.phisikus.rubik.cube.sides.{CubeSide, RubiksCubeSide}
import pl.linux.platinum.phisikus.rubik.cube.{RubiksCube, Cube}

import scala.annotation.tailrec
import scala.util.Random

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
    val reversedPosition = cube.size - 1 - position
    val northSide = getCubeSideReplaceColumn(reversedPosition, cube.top.getColumn(position), cube.north.elements)
    val bottomSide = getCubeSideReplaceColumn(position, cube.north.getColumn(reversedPosition), cube.bottom.elements)
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
    val reversedPosition = cube.size - 1 - position
    val northSide = getCubeSideReplaceColumn(reversedPosition, cube.bottom.getColumn(position), cube.north.elements)
    val bottomSide = getCubeSideReplaceColumn(position, cube.south.getColumn(position), cube.bottom.elements)
    val southSide = getCubeSideReplaceColumn(position, cube.top.getColumn(position), cube.south.elements)
    val topSide = getCubeSideReplaceColumn(position, cube.north.getColumn(reversedPosition), cube.top.elements)
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
    val reversedPosition = cube.size - 1 - position
    val westSide = getCubeSideReplaceColumn(reversedPosition, cube.bottom.getRow(position), cube.west.elements)
    val topSide = getCubeSideReplaceRow(reversedPosition, cube.west.getColumn(reversedPosition).reverse, cube.top.elements)
    val eastSide = getCubeSideReplaceColumn(position, cube.top.getRow(reversedPosition), cube.east.elements)
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
    val reversedPosition = cube.size - 1 - position
    val westSide = getCubeSideReplaceColumn(reversedPosition, cube.top.getRow(reversedPosition).reverse, cube.west.elements)
    val topSide = getCubeSideReplaceRow(reversedPosition, cube.east.getColumn(position), cube.top.elements)
    val eastSide = getCubeSideReplaceColumn(position, cube.bottom.getRow(position).reverse, cube.east.elements)
    val bottomSide = getCubeSideReplaceRow(position, cube.west.getColumn(reversedPosition), cube.bottom.elements)
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

  @tailrec
  override final def getRandomCube(cube: Cube, randomizations: Integer): Cube = {
    val randomizer = new Random(System.currentTimeMillis());
    randomizations match {
      case x if x > 0 =>
        randomizer.nextInt(5) match {
          case 0 => getRandomCube(turnColumn(randomizer.nextInt(cube.size - 1), true, cube), randomizations - 1)
          case 1 => getRandomCube(turnColumn(randomizer.nextInt(cube.size - 1), false, cube), randomizations - 1)
          case 2 => getRandomCube(turnRow(randomizer.nextInt(cube.size - 1), true, cube), randomizations - 1)
          case 3 => getRandomCube(turnRow(randomizer.nextInt(cube.size - 1), false, cube), randomizations - 1)
          case 4 => getRandomCube(turnSide(randomizer.nextInt(cube.size - 1), true, cube), randomizations - 1)
          case 5 => getRandomCube(turnSide(randomizer.nextInt(cube.size - 1), false, cube), randomizations - 1)
        }
      case _ => cube
    }

  }


}
