package com.org.apache.producers

import com.org.apache.utils.KafkaProducerSource
import org.apache.kafka.clients.producer.ProducerRecord

object ProducerWithCustomPartitioner extends App {

  val producer = KafkaProducerSource.getKafkaCustomPartitionerProducer[String, String]()

  try {
    for(i <- 1 to 10){
      producer.send(new ProducerRecord("first_topic", "Hello! Apache Kafka_" + i))
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
