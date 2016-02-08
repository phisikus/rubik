package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.CubieColor._
import pl.linux.platinum.phisikus.cube.cubies.StandardCubie

/**
  * Created by phisikus on 08.02.16.
  */
object CubieMatrixFactory {

  def getMatrixOfCubies(cubieColor: CubieColor, size: Integer) = {

    def getListOfElements[X](quantity: Integer, factory: () => X): List[X] = {
      quantity match {
        case x if x > 0 => factory() :: getListOfElements(x - 1, factory)
        case _ => List()
      }
    }

    val getSingleCubieLambda = () => new StandardCubie(cubieColor)
    val getSingleRowOfElementsLambda = () => getListOfElements(size, getSingleCubieLambda)
    getListOfElements(size, getSingleRowOfElementsLambda)

  }

}
