package com.org.apache.utils

import org.apache.kafka.clients.producer.KafkaProducer

object KafkaProducerSource {

  /**
    * This method is used to create Kafka Producer
    *
    * @tparam T
    * @tparam U
    * @return KafkaProducer
    */
  def getKafkaProducer[T, U](): KafkaProducer[T, U] = {
    var kafkaProducer: KafkaProducer[T, U] = null

    //Create producer properties
    val props = ProducerKafkaProperties.kafkaProducerProperties

    //Create Producer
    kafkaProducer = new KafkaProducer[T, U](props)
    kafkaProducer
  }

  /**
    * This method is used to create Kafka Producer for Custom Partitioner
    *
    * @tparam T
    * @tparam U
    * @return KafkaProducer
    */
  def getKafkaCustomPartitionerProducer[T, U](): KafkaProducer[T, U] = {
    var kafkaProducer: KafkaProducer[T, U] = null

    //Create producer properties
    val props = ProducerKafkaProperties.kafkaProdPropForCustomePartitioner

    //Create Producer
    kafkaProducer = new KafkaProducer[T, U](props)
    kafkaProducer
  }

  /**
    * It creates Custom Serializer Kafka Producer.
    *
    * @tparam T
    * @tparam U
    * @return
    */
  def customSerializerKafkaProducer[T,U](): KafkaProducer[T,U] = {
    var kafkaProducer: KafkaProducer[T,U] = null

    //Create Properties
    val properties = ProducerKafkaProperties.kafkaPropsForCustomSerializer

    //Create Producer
    kafkaProducer = new KafkaProducer[T,U](properties)
    kafkaProducer
  }


}
