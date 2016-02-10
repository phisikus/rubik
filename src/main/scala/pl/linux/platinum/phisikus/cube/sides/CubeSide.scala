package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.Cubie

/** Side of Rubik's Cube.
  * Rubik's Cube side is represented as a Vector of columns containing Vector of Cubies (or rather sides of a cubie).
  * The first Cubie elements(0)(0) is in the right-down corner. The second cubie on that list is above it. The next column is placed on the left.
  *
  */
trait CubeSide {
  def size: Integer = elements.length
  def elements: Vector[Vector[Cubie]]
  def getColumn(i : Integer) : Vector[Cubie]
  def getRow(i : Integer) : Vector[Cubie]
  def isSolved : Boolean
}
