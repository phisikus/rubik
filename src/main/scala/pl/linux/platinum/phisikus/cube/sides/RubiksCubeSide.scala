package pl.linux.platinum.phisikus.cube.sides

import pl.linux.platinum.phisikus.cube.cubies.Cubie

import scala.reflect.ClassTag

/**
  * Created by phisikus on 07.02.16.
  */
class RubiksCubeSide(cubies: List[List[Cubie]]) extends CubeSide {
  override def elements: List[List[Cubie]] = cubies

  override def toString: String = {
    def stringifyList[X](elements: List[X]): String = {
      elements match {
        case head :: tail =>
          head match {
            case x : List[Any] => stringifyList(x) + stringifyList(tail)
            case x : String => x.toString + stringifyList(tail)
          }
        case Nil => ""
      }
    }
    stringifyList[List[Cubie]](cubies)
  }
}
