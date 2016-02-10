package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.Cubie
import pl.linux.platinum.phisikus.cube.cubies.CubieColor.CubieColor

import scala.annotation.tailrec


/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCubeSide(cubies: List[List[Cubie]]) extends CubeSide {
  override def elements: List[List[Cubie]] = cubies

  def this(cubieColor: CubieColor, size: Integer) = {
    this(CubieMatrixFactory.getMatrixOfCubies(cubieColor, size))
  }


  override def isSolved: Boolean = {
    @tailrec
    def allElementsAreEqual(list: List[Any]): Boolean = {
      list match {
        case e1 :: e2 :: tail => e1 == e2 && allElementsAreEqual(e2 :: tail)
        case e1 => true
      }
    }
    allElementsAreEqual(elements) && elements.map(singleRow => allElementsAreEqual(singleRow)).reduce((singleRow, result) => singleRow && result)
  }

  override def equals(o: scala.Any): Boolean = o match {
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

  override def getColumn(i: Integer): List[Cubie] = {
    elements.map(column => column(i))
  }

  override def getRow(i: Integer): List[Cubie] = {
    elements(i)
  }
}
