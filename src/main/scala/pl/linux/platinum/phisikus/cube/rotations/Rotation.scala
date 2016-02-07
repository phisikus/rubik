package pl.linux.platinum.phisikus.cube.rotations

import pl.linux.platinum.phisikus.cube.Cube

/**
  * Created by phisikus on 07.02.16.
  */
trait Rotation {
  def apply(cube: Cube): Cube
}
