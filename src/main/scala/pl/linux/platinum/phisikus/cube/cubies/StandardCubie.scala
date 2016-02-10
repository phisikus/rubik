package pl.linux.platinum.phisikus.cube.cubies

/**
  * Created by phisikus on 07.02.16.
  */
class StandardCubie(cubieColor: CubieColor.Value) extends Cubie {
  override def color: CubieColor.Value = cubieColor

  override def hashCode(): Int = 41 * super.hashCode() + cubieColor.hashCode()

  override def equals(toCompare: scala.Any): Boolean = toCompare match {
    case toCompare: StandardCubie => toCompare.color == this.color
    case _ => false
  }

  override def toString: String = {
    " " + cubieColor.toString + " "
  }
}
