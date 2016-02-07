package pl.linux.platinum.phisikus.cube.cubies

/**
  * Created by phisikus on 07.02.16.
  */
class StandardCubie(cubieColor: CubieColor.Value) extends Cubie {
  override def color: CubieColor.Value = cubieColor

  override def toString: String = {
    " " + cubieColor.toString + " "
  }
}
