package apache.kafka.scala.consumers

import java.util

import apache.kafka.scala.constants.Kafka
import apache.kafka.scala.utils.{ConsumerKafkaProperties, ProducerKafkaProperties}
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.common.TopicPartition
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._
import scala.util.control.Breaks

object SimpleConsumerWithAssignSeek extends App {

  implicit val logger = LoggerFactory.getLogger(SimpleConsumerWithAssignSeek.getClass)
  val offsetToReadFrom = 20L;
  val numberOfMessagesToRead = 10
  var keepOnReading = true
  var numberOfMessagesReadSoFar = 0
  val loop = new Breaks;
  val partitionNumber = 2

  //Create Consumer config-Properties
  val properties = ConsumerKafkaProperties.kafkaConsumerProperties(null)

  logger.info("Consumer config created with properties \n" +
    "BootstrapServer: " + properties.getProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG) + "\n" +
    "Key Deserializer: " + properties.getProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG) + "\n" +
    "Value Deserializer: " + properties.getProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG) + "\n" +
    "Groud Id: " + properties.getProperty(ConsumerConfig.GROUP_ID_CONFIG))

  //Create Consumer
  val consumer = new KafkaConsumer[String, String](properties)

  //Assign and Seek are used to replay a data or fetch specific message

  //assign
  val partitionToRead = new TopicPartition(Kafka.FIRST_TOPIC, partitionNumber)
  consumer.assign(util.Arrays.asList(partitionToRead))

  //seek
  consumer.seek(partitionToRead, offsetToReadFrom)

  //poll for new data
  while (keepOnReading) {
    val records = consumer.poll(100) // In Kafka 2.0 - consumer.poll(Duration.ofMillis(100))
    loop.breakable {
      for (record <- records.asScala) {
        numberOfMessagesReadSoFar += 1
        logger.info("Key: " + record.key + ", Value: " + record.value)
        logger.info("Partition: " + record.partition + ", Offset:" + record.offset)
        if (numberOfMessagesReadSoFar >= numberOfMessagesToRead) {
          keepOnReading = false; // to exit the while loop
          loop.break; // to exit the for loop
        }
      }
    }
    logger.info("Existing the application")
  }
}
