package com.org.apache.consumers

import java.util

import com.org.apache.constants.Kafka
import com.org.apache.models.Employee
import com.org.apache.utils.ConsumerKafkaProperties
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
