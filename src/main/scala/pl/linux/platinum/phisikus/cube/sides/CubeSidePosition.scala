package pl.linux.platinum.phisikus.cube.sides

/**
  * Created by phisikus on 08.02.16.
  */
object CubeSidePosition extends Enumeration {
  type CubeSidePosition = Value
  val NORTH = Value("N")
  val SOUTH = Value("S")
  val EAST = Value("E")
  val WEST = Value("W")
  val TOP = Value("T")
  val BOTTOM = Value("B")
}
