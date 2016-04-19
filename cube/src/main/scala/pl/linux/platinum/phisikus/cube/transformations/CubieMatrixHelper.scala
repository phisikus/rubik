package pl.linux.platinum.phisikus.cube.transformations

import pl.linux.platinum.phisikus.cube.cubies.CubieColor._
import pl.linux.platinum.phisikus.cube.cubies.{Cubie, StandardCubie}

/**
  * Created by phisikus on 08.02.16.
  */
object CubieMatrixHelper {

  def getMatrixOfCubies(cubieColor: CubieColor, size: Integer) = {

    def getVectorOfElements[X](quantity: Integer, factory: () => X): Vector[X] = {
      quantity match {
        case x if x > 0 => Vector(factory()) ++ getVectorOfElements(x - 1, factory)
        case _ => Vector()
      }
    }

    val getSingleCubieLambda = () => new StandardCubie(cubieColor)
    val getSingleRowOfElementsLambda = () => getVectorOfElements(size, getSingleCubieLambda)
    getVectorOfElements(size, getSingleRowOfElementsLambda)

  }


  def getMatrixOfCubiesReplaceRow(position: Integer, row: Vector[Cubie], cubies: Vector[Vector[Cubie]]): Vector[Vector[Cubie]] = {
    cubies.updated(position, row)
  }

  def getMatrixOfCubiesReplaceColumn(position: Integer, column: Vector[Cubie], cubies: Vector[Vector[Cubie]]): Vector[Vector[Cubie]] = {
    cubies.zipWithIndex.map(row => row._1.updated(position, column(row._2)))
  }

  def getMatrixOfCubiesTurnedRight(cubies: Vector[Vector[Cubie]]): Vector[Vector[Cubie]] = {
    cubies.transpose.map(row => row.reverse)
  }

  def getMatrixOfCubiesTurnedLeft(cubies: Vector[Vector[Cubie]]): Vector[Vector[Cubie]] = {
    cubies.transpose.reverse
  }


}
