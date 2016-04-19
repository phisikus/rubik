package pl.linux.platinum.phisikus.serializers

/**
  * Created by phisikus on 08.02.16.
  */
trait Serializer[T] {
  def serialize(obj: T): Array[Byte]

  def deserialize(input: Array[Byte]): T
}
