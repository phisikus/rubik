package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.CubieColor._
import pl.linux.platinum.phisikus.cube.cubies.StandardCubie

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

}
