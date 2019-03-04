package com.org.apache.utils

import java.io.{ByteArrayOutputStream, ObjectOutputStream}
import java.util

import org.apache.kafka.common.serialization.Serializer


class CustomSerializer extends Serializer[Any] {

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {
  }

  override def serialize(topic: String, data: Any): Array[Byte] = {

    val byteArrayOutputStream = new ByteArrayOutputStream
    val objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)

    objectOutputStream.writeObject(data)
    objectOutputStream.close
    byteArrayOutputStream.toByteArray
  }

  override def close(): Unit = {
  }
}
