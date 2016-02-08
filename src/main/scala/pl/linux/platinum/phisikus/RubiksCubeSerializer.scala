package pl.linux.platinum.phisikus

import pl.linux.platinum.phisikus.cube.{Cube, CubeSerializer}

import scala.pickling._         // This imports names only
import scala.pickling.json._    // Imports PickleFormat
import scala.pickling.static._  // Avoid runtime pickler

// Import pickle ops
import scala.pickling.Defaults.{ pickleOps, unpickleOps }
// Alternatively import pickle function
// import scala.pickling.functions._

// Import picklers for specific types
import scala.pickling.Defaults.{ stringPickler, intPickler, refUnpickler, nullPickler }
/**
  * Created by phisikus on 08.02.16.
  */
class RubiksCubeSerializer extends CubeSerializer {

  override def serialize(cube: Cube): String = {
//    val json = cube.pickle
null
  }

  override def deserialize(text: String): Cube = {
   null
  }
}
