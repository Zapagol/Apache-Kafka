package com.org.apache.producers

import com.org.apache.constants.{Kafka, Messages}
import com.org.apache.utils.{KafkaProducerSource, ProducerCallback}
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory

object ProducerWithKeyValue extends App {

  implicit val logger = LoggerFactory.getLogger(ProducerWithKeyValue.getClass)
  val producer = KafkaProducerSource.getKafkaProducer[String, String]()

  //send data - asynchronous
  for(i <- 1 to 10){
    var value = Messages.HELLO_KEY_VALUE + Integer.toString(i)
    var key = Messages.KEY_ID + Integer.toString(i)

    logger.info("Key: " + key)

    //id_1 partition 0
    //id_2 partition 2
    //id_3 partition 0
    //id_4 partition 2
    //id_5 partition 2

    producer.send(new ProducerRecord[String, String](Kafka.FIRST_TOPIC, key, value),
      new ProducerCallback).get() // Block the .send() to make it asynchronous.
  }
  //flush data
  producer.flush()
  //flush and close producer
  producer.close()
}
