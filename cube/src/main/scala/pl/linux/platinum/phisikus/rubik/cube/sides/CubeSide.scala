package pl.linux.platinum.phisikus.rubik.cube.sides

import pl.linux.platinum.phisikus.rubik.cube.cubies.Cubie

/** Side of Rubik's Cube. It should contain 2 dimensional matrix of Cubies - colored tiles.
  *
  */
trait CubeSide {
  def size: Integer = elements.length

  def elements: Vector[Vector[Cubie]]

  def getColumn(i: Integer): Vector[Cubie]

  def getRow(i: Integer): Vector[Cubie]

  def isSolved: Boolean
}
