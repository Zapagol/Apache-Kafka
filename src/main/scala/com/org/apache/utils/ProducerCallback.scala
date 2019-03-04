package com.org.apache.utils

import org.apache.kafka.clients.producer.{Callback, RecordMetadata}
import org.slf4j.Logger

class ProducerCallback(implicit logger: Logger) extends Callback {

  override def onCompletion(metadata: RecordMetadata, exception: Exception): Unit = {
    //executes every time a record is successfully sent or exception thrown
    Option(metadata) match {
      case Some(_) =>
        logger.info("Received new metadata. \n" +
          "Topic: " + metadata.topic() + "\n" +
          "Partition: " + metadata.partition() + "\n" +
          "Offset: " + metadata.offset() + "\n" +
          "Timestamp: " + metadata.timestamp() + "\n" +
          "Checksum: " + metadata.checksum())
      case None => ;
    }
    Option(exception) match {
      case Some(_) =>
        logger.error("Exception thrown during processing of record... " + exception)
        throw exception
      case None => ;
    }
  }
}
