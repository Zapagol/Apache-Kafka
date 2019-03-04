package com.org.apache.producers

import com.org.apache.constants.Kafka
import com.org.apache.models.Employee
import com.org.apache.utils.{KafkaProducerSource, ProducerCallback}
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory

object ProducerWithCustomSerializer extends App {

  implicit val logger = LoggerFactory.getLogger(ProducerWithCustomSerializer.getClass)

  var employeeList: List[Employee] = List()

  val producer = KafkaProducerSource.customSerializerKafkaProducer[String, Employee]()
  logger.info("Producer has been created successfully")

  //Prepare Data
  for(i <- 1 to 5){
    val name = "Edward_" + i
    val id = i
    val number = "231231231" + i
    val sal = 10000 + i*10

    val employee = Employee(name,id,number,sal)
    employeeList = employee :: employeeList
  }

  //Send data to Kafka
  employeeList.foreach( employee =>
    producer.send(new ProducerRecord[String,Employee](Kafka.EMPLOYEE_TOPIC,employee),
      new ProducerCallback)
  )
  logger.info("Custom Serializer Producer has sent data successfully..")

  //flush data
  producer.flush()
  //flush and close producer
  producer.close()

}
