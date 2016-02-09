package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.Cubie

/** Side of Rubik's Cube.
  * Rubik's Cube side is represented as a List of columns containing List of Cubies (or rather sides of a cubie).
  * The first Cubie elements(0)(0) is in the right-down corner. The second cubie on that list is above it. The next column is placed on the left.
  *
  */
trait CubeSide {
  def size: Integer = elements.length
  def elements: List[List[Cubie]]
  def getColumn(i : Integer) : List[Cubie]
  def getRow(i : Integer) : List[Cubie]
  def isSolved : Boolean
}
