package com.org.apache.producers

import com.org.apache.utils.KafkaProducerSource
import org.apache.kafka.clients.producer.ProducerRecord

object SimpleProducer extends App {

  val producer = KafkaProducerSource.getKafkaProducer[String, String]()

  try {
    //Send data - asynchronous
    for(i <- 1 to 10) {
      producer.send(new ProducerRecord("first_topic", "Hello! Welcome to Apache Kafka tutorial_" + i))
    }
    //flush data
    producer.flush()
    //flush and close producer
    producer.close()
  } catch {
    case e: Exception =>
      e.printStackTrace()
  }
}
