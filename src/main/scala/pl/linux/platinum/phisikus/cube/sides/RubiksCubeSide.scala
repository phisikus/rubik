package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.CubieColor.CubieColor
import pl.linux.platinum.phisikus.cube.cubies.{Cubie, StandardCubie}

import scala.annotation.tailrec

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


  override def toString: String = {
    def stringifyList[X](elements: List[X]): String = {
      elements match {
        case head :: tail =>
          head match {
            case x: List[Any] => "[" + stringifyList(x) +  "]\n" + stringifyList(tail)
            case x: Cubie => x.toString + stringifyList(tail)
          }
        case Nil => ""
      }
    }
    stringifyList[List[Cubie]](cubies)
  }
}
