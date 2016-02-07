package pl.linux.platinum.phisikus.cube

import pl.linux.platinum.phisikus.cube.cubies.CubieColor
import pl.linux.platinum.phisikus.cube.sides.{CubeSide, RubiksCubeSide}

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCube(topSide: CubeSide, bottomSide: CubeSide, northSide: CubeSide, southSide: CubeSide, eastSide: CubeSide, westSide: CubeSide) extends Cube {
  def this(sides: List[CubeSide]) {
    this(sides(0), sides(1), sides(2), sides(3), sides(4), sides(5))
  }

  def this() {
    this(new RubiksCubeSide(CubieColor.WHITE),
      new RubiksCubeSide(CubieColor.YELLOW),
      new RubiksCubeSide(CubieColor.ORANGE),
      new RubiksCubeSide(CubieColor.RED),
      new RubiksCubeSide(CubieColor.BLUE),
      new RubiksCubeSide(CubieColor.GREEN))
  }

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
    (((((17 + north.hashCode()) * 13 + south.hashCode()) * 13 + east.hashCode()) * 13 + west.hashCode()) * 13 + top.hashCode()) * 13 + bottom.hashCode()
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
}
