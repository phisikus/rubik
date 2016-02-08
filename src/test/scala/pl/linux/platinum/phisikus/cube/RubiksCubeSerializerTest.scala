package pl.linux.platinum.phisikus.cube

import org.scalatest.FlatSpec
import pl.linux.platinum.phisikus.RubiksCubeSerializer

/**
  * Created by phisikus on 08.02.16.
  */
class RubiksCubeSerializerTest extends FlatSpec{

  val serializer = new RubiksCubeSerializer

  "RubiksCubeSerializer" should "serialize and deserialize to she same object" in {
    val objectToSerialize = new RubiksCube(4)
    val serializedString = serializer.serialize(objectToSerialize)
    println(serializedString)
  }

}
