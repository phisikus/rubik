package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.CubieColor.CubieColor
import pl.linux.platinum.phisikus.cube.cubies.{Cubie, StandardCubie}

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCubeSide(cubies: List[List[Cubie]]) extends CubeSide {
  override def elements: List[List[Cubie]] = cubies

  def this(cubieColor: CubieColor) = {
    this(List(
      List(new StandardCubie(cubieColor), new StandardCubie(cubieColor), new StandardCubie(cubieColor)),
      List(new StandardCubie(cubieColor), new StandardCubie(cubieColor), new StandardCubie(cubieColor)),
      List(new StandardCubie(cubieColor), new StandardCubie(cubieColor), new StandardCubie(cubieColor))
    ))
  }


  override def equals(o: scala.Any): Boolean = o match {
    case toCompare: RubiksCubeSide => this.elements == toCompare.elements
    case _ => false
  }


  override def hashCode(): Int = {
    super.hashCode() * 31 + cubies.hashCode()
  }

  override def toString: String = {
    elements.map(
      singleRow => singleRow.map(element => element.toString).reduce((singleElement, result) => singleElement + " " + result) + "\n"
    ).reduce((singleRow, result) => singleRow + result)
  }
}
