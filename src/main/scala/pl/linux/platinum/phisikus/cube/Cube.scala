package pl.linux.platinum.phisikus.cube

import pl.linux.platinum.phisikus.cube.cubies.Cubie
import pl.linux.platinum.phisikus.cube.sides.{CubeSide, CubeSidePosition}

/** Rubik's Cube
  * The cube consists of 6 walls: T (top), B (bottom), N (north), S (south), E (east), W (west).
  * It is arranged like this:
  * - - T - - - -
  * W - S - E - N
  * - - B - - - -
  *
  */
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
