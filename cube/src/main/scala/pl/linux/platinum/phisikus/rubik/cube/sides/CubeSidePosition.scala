package pl.linux.platinum.phisikus.rubik.cube.sides

/** CubeSidePosition represents possible CubeSide positions in cube (Top/Bottom/North/South/East/West)
  *
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
