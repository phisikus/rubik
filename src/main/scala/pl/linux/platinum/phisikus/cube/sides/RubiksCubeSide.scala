package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.Cubie
import pl.linux.platinum.phisikus.cube.cubies.CubieColor.CubieColor
import pl.linux.platinum.phisikus.cube.transformations.CubieMatrixHelper

import scala.annotation.tailrec


class RubiksCubeSide(cubies: Vector[Vector[Cubie]]) extends CubeSide {
  override def elements: Vector[Vector[Cubie]] = cubies

  def this(cubieColor: CubieColor, size: Integer) = {
    this(CubieMatrixHelper.getMatrixOfCubies(cubieColor, size))
  }


  override def isSolved: Boolean = {
    @tailrec
    def allElementsAreEqual(list: Vector[Any]): Boolean = {
      list match {
        case e1 +: e2 +: tail => e1 == e2 && allElementsAreEqual(Vector(e2) ++ tail)
        case e1 => true
      }
    }
    allElementsAreEqual(elements) && elements.map(singleRow => allElementsAreEqual(singleRow)).reduce((singleRow, result) => singleRow && result)
  }

  override def equals(toCompare: scala.Any): Boolean = toCompare match {
    case toCompare: RubiksCubeSide => this.elements == toCompare.elements
    case _ => false
  }


  override def hashCode(): Int = {
    (super.hashCode() * 31 + cubies.hashCode()) * 31 + size
  }

  override def toString: String = {
    elements.map(
      singleRow => singleRow.map(element => element.toString).reduce((singleElement, result) => singleElement + " " + result) + "\n"
    ).reduce((singleRow, result) => singleRow + result)
  }

  override def getColumn(i: Integer): Vector[Cubie] = {
    elements.map(column => column(i))
  }

  override def getRow(i: Integer): Vector[Cubie] = {
    elements(i)
  }
}
