package pl.linux.platinum.phisikus.cube.transformations

import pl.linux.platinum.phisikus.cube.Cube

/**
  * Created by phisikus on 10.02.16.
  */
trait Transformer {
  def turnColumn(position: Integer, clockWise: Boolean, cube: Cube): Cube

  def turnRow(position: Integer, clockWise: Boolean, cube: Cube): Cube
}
