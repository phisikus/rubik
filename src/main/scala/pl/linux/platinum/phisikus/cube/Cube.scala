package pl.linux.platinum.phisikus.cube

import pl.linux.platinum.phisikus.cube.cubies.Cubie
import pl.linux.platinum.phisikus.cube.sides.{CubeSide, CubeSidePosition}


trait Cube {
  def north: CubeSide

  def south: CubeSide

  def east: CubeSide

  def west: CubeSide

  def top: CubeSide

  def bottom: CubeSide

  def size: Integer

  def isSolved: Boolean

  def getCubie(cubeSidePosition: CubeSidePosition.Value, row: Integer, column: Integer): Cubie
}
