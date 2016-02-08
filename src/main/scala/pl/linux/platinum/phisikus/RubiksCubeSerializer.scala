package pl.linux.platinum.phisikus

import java.io.ByteArrayOutputStream

import com.esotericsoftware.kryo.io.Input
import com.twitter.chill.{Output, ScalaKryoInstantiator}
import pl.linux.platinum.phisikus.cube.{CubeSerializer, RubiksCube}

/**
  * Created by phisikus on 08.02.16.
  */
class RubiksCubeSerializer extends CubeSerializer {

  val instantiator = new ScalaKryoInstantiator
  instantiator.setRegistrationRequired(false)
  val kryoInstantiator = instantiator.newKryo()

  override def serialize(cube: RubiksCube) = {
    val outputStream = new ByteArrayOutputStream
    val output = new Output(outputStream, 4096)
    kryoInstantiator.writeObject(output, cube)
    outputStream.toByteArray
  }

  override def deserialize(input: Array[Byte]): RubiksCube = {
    val inputStream = new Input(input)
    kryoInstantiator.readObject(inputStream, classOf[RubiksCube])
  }
}
