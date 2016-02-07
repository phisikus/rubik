package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.Cubie

/**
  * Created by phisikus on 07.02.16.
  */
trait CubeSide {
  def size: Integer = elements.length
  def elements: List[List[Cubie]]
}
