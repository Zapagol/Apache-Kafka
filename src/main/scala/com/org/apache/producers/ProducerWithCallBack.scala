package com.org.apache.producers

import com.org.apache.constants.{Kafka, Messages}
import com.org.apache.utils.{KafkaProducerSource, ProducerCallback}
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory

object ProducerWithCallBack extends App {

  implicit val logger = LoggerFactory.getLogger(ProducerWithCallBack.getClass)
  val producer = KafkaProducerSource.getKafkaProducer[String, String]()

  //send data - asynchronous
  for(i <- 1 to 5){
    producer.send(new ProducerRecord[String, String](Kafka.FIRST_TOPIC,
      Messages.HELLO_KAFKA_MESSAGE + Integer.toString(i)),new ProducerCallback)
  }
  //flush data
  producer.flush()
  //flush and close producer
  producer.close()
}
