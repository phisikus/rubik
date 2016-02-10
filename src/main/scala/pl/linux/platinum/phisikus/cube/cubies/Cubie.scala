package pl.linux.platinum.phisikus.cube.cubies

/** Cubie represents the smallest part of Rubik's Cube. Here Cubie represents one, colored side of a cubie.
  *
  */
trait Cubie {
  def color : CubieColor.Value
}
