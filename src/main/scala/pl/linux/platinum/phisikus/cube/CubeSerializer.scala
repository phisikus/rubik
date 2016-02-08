package pl.linux.platinum.phisikus.cube

/**
  * Created by phisikus on 08.02.16.
  */
trait CubeSerializer {
  def serialize(cube: Cube): String

  def deserialize(text : String): Cube
}
