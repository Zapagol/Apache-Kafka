package com.org.apache.utils

import java.io.{ByteArrayInputStream, ObjectInputStream}
import java.util

import org.apache.kafka.common.serialization.Deserializer

class CustomDeserializer extends Deserializer[Any] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def deserialize(topic: String, data: Array[Byte]): Any = {

    val objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))
    val obj = objectInputStream.readObject().asInstanceOf[Any]
    objectInputStream.close()
    obj
  }

  override def close(): Unit = {}

}
