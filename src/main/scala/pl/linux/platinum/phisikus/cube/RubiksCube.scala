package pl.linux.platinum.phisikus.cube

import _root_.pl.linux.platinum.phisikus.cube.transformations.{RubiksCubeTransformer, Transformer}
import pl.linux.platinum.phisikus.cube.cubies.{Cubie, CubieColor}
import pl.linux.platinum.phisikus.cube.sides.{CubeSide, CubeSidePosition, RubiksCubeSide}

import scala.annotation.tailrec
import scala.util.Random

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCube(topSide: CubeSide, bottomSide: CubeSide, northSide: CubeSide, southSide: CubeSide, eastSide: CubeSide, westSide: CubeSide) extends Cube {
  def this(sides: Vector[CubeSide]) {
    this(sides.head, sides(1), sides(2), sides(3), sides(4), sides(5))
  }

  def this(size: Integer = 3) {
    this(new RubiksCubeSide(CubieColor.WHITE, size),
      new RubiksCubeSide(CubieColor.YELLOW, size),
      new RubiksCubeSide(CubieColor.ORANGE, size),
      new RubiksCubeSide(CubieColor.RED, size),
      new RubiksCubeSide(CubieColor.BLUE, size),
      new RubiksCubeSide(CubieColor.GREEN, size))
  }

  private val transformer: Transformer = new RubiksCubeTransformer
  private val randomizer = new Random(System.currentTimeMillis());

  override def size: Integer = northSide.size

  override def north: CubeSide = northSide

  override def bottom: CubeSide = bottomSide

  override def west: CubeSide = westSide

  override def top: CubeSide = topSide

  override def south: CubeSide = southSide

  override def east: CubeSide = eastSide

  override def toString: String = {
    "North:\n" + northSide.toString +
      "Top:\n" + topSide.toString +
      "South:\n" + southSide.toString +
      "West:\n" + westSide.toString +
      "East:\n" + eastSide.toString +
      "Bottom:\n" + bottomSide.toString
  }

  override def hashCode(): Int = {
    ((((((17 + north.hashCode()) * 13 + south.hashCode()) * 13 + east.hashCode()) * 13 + west.hashCode()) * 13 + top.hashCode()) * 13 + bottom.hashCode()) * 17 + size
  }

  override def equals(o: scala.Any): Boolean = {
    o match {
      case toCompare: RubiksCube =>
        north == toCompare.north &&
          south == toCompare.south &&
          east == toCompare.east &&
          west == toCompare.west &&
          top == toCompare.top &&
          bottom == toCompare.bottom
      case _ => false

    }
  }

  override def isSolved: Boolean = {
    north.isSolved && south.isSolved && east.isSolved && west.isSolved && top.isSolved && bottom.isSolved
  }

  override def getCubie(cubeSidePosition: CubeSidePosition.Value, row: Integer, column: Integer): Cubie = {
    val side = cubeSidePosition match {
      case CubeSidePosition.NORTH => north
      case CubeSidePosition.SOUTH => south
      case CubeSidePosition.EAST => east
      case CubeSidePosition.WEST => west
      case CubeSidePosition.TOP => top
      case CubeSidePosition.BOTTOM => bottom
    }
    side.elements(row)(column)
  }

  @tailrec
  override final def getRandomCube(cube: Cube, randomizations: Integer): Cube = {
    randomizations match {
      case x if x > 0 =>
        randomizer.nextInt(5) match {
          case 0 => getRandomCube(transformer.turnColumn(randomizer.nextInt(cube.size - 1), true, cube), randomizations - 1)
          case 1 => getRandomCube(transformer.turnColumn(randomizer.nextInt(cube.size - 1), false, cube), randomizations - 1)
          case 2 => getRandomCube(transformer.turnRow(randomizer.nextInt(cube.size - 1), true, cube), randomizations - 1)
          case 3 => getRandomCube(transformer.turnRow(randomizer.nextInt(cube.size - 1), false, cube), randomizations - 1)
          case 4 => getRandomCube(transformer.turnSide(randomizer.nextInt(cube.size - 1), true, cube), randomizations - 1)
          case 5 => getRandomCube(transformer.turnSide(randomizer.nextInt(cube.size - 1), false, cube), randomizations - 1)
        }
      case _ => cube
    }

  }
}
