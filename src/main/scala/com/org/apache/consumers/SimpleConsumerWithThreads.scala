package apache.kafka.scala.consumers

import java.util

import apache.kafka.scala.constants.Kafka
import apache.kafka.scala.utils.{ConsumerKafkaProperties, ProducerKafkaProperties}
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

object SimpleConsumerWithThreads extends App {

  implicit val logger = LoggerFactory.getLogger(SimpleConsumer.getClass)

  //Create consumer properties
  val props = ConsumerKafkaProperties.kafkaConsumerProperties(Kafka.GROUP_ID_2)

  val consumer = new KafkaConsumer[String, String](props)

  consumer.subscribe(util.Arrays.asList(Kafka.FIRST_TOPIC))

  while(true){
    val records=consumer.poll(100)
    for (record<-records.asScala){
      logger.info("Key: " + record.key + ", Value: " + record.value)
      logger.info("Partition: " + record.partition + ", Offset:" + record.offset)
    }
  }

}
