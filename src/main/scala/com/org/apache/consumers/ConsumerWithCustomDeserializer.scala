package apache.kafka.scala.consumers

import java.util

import apache.kafka.scala.constants.Kafka
import apache.kafka.scala.models.Employee
import apache.kafka.scala.utils.ConsumerKafkaProperties
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

object ConsumerWithCustomDeserializer extends App {

  implicit val logger = LoggerFactory.getLogger(SimpleConsumer.getClass)

  //Create consumer properties
  val props = ConsumerKafkaProperties.kafkaPropsForCustomDeserializer

  val consumer = new KafkaConsumer[String, Employee](props)

  consumer.subscribe(util.Arrays.asList(Kafka.EMPLOYEE_TOPIC))

  while(true){
    val records=consumer.poll(100)
    for (record<-records.asScala){
      logger.info("Employee Name = " + record.value.name + " Employee  ID = " + record.value.id +
        " Salary = " + record.value.salary + " Mobile Number = " + record.value.mobileNumber);
    }
  }
}
