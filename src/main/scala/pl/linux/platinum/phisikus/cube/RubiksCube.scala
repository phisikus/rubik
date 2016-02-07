package pl.linux.platinum.phisikus.cube

import pl.linux.platinum.phisikus.cube.sides.CubeSide

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCube(topSide: CubeSide, bottomSide: CubeSide, northSide: CubeSide, southSide: CubeSide, eastSide: CubeSide, westSide: CubeSide) extends Cube {
  def this(sides: List[CubeSide]) {
    this(sides(0), sides(1), sides(2), sides(3), sides(4), sides(5))
  }

  override def north: CubeSide = northSide

  override def bottom: CubeSide = bottomSide

  override def west: CubeSide = westSide

  override def top: CubeSide = topSide

  override def south: CubeSide = southSide

  override def east: CubeSide = eastSide

  override def toString: String = {
    "North: " + northSide.toString +
      "Top: " + topSide.toString +
      "South: " + southSide.toString +
      "West: " + westSide.toString +
      "East: " + eastSide.toString +
      "Bottom: " + bottomSide.toString
  }
}