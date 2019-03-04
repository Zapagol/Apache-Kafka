package com.org.apache.utils

import java.util.Properties

import com.org.apache.constants.Kafka
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig

object ProducerKafkaProperties {

  /**
    * This creates Kafka Producer Properties
    * for simple producer.
    *
    * @return Properties
    */
  def kafkaProducerProperties(): Properties = {

    val properties = new Properties
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Kafka.BOOTSTRAPSERVERS)
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Kafka.STRING_KEY_SERIALIZER)
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Kafka.STRING_VALUE_SERIALIZER)

    properties
  }

  /**
    * This creates Kafka Producer Properties for Custom
    * Partitioner Producer.
    *
    * @return
    */

  def kafkaProdPropForCustomePartitioner(): Properties = {
    val properties = new Properties
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,Kafka.BOOTSTRAPSERVERS)
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Kafka.STRING_KEY_SERIALIZER)
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Kafka.STRING_VALUE_SERIALIZER)
    properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, Kafka.COUNTRY_PARTIOTIONER_CLASS_PATH)
    properties.put(Kafka.PARTITION_ZERO_COUNTRY_NAME,Kafka.PARTITION_ZERO_COUNTRY_NAME_VALUE)

    properties
  }

  /**
    * This creates Properties for Custom Serializer Producer.
    *
    * @return
    */
  def kafkaPropsForCustomSerializer(): Properties = {
    val props = new Properties
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Kafka.BOOTSTRAPSERVERS)
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Kafka.STRING_KEY_SERIALIZER)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Kafka.CUSTOM_SERIALIZER)

    props
  }

  /**
    * This Creates Kafka Consumer Properties
    *
    * @return Properties
    */
  def kafkaConsumerProperties(group_id: String): Properties = {

    val properties = new Properties

    if(group_id == null || group_id.isEmpty) {
      properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Kafka.BOOTSTRAPSERVERS)
      properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, Kafka.STRING_KEY_DESERIALIZER)
      properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, Kafka.STRING_VALUE_DESERIALIZER)
      properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Kafka.OFFSET_RESET_CONFIG_EARLIEST)
    }else{
      properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Kafka.BOOTSTRAPSERVERS)
      properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, Kafka.STRING_KEY_DESERIALIZER)
      properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, Kafka.STRING_VALUE_DESERIALIZER)
      properties.put(ConsumerConfig.GROUP_ID_CONFIG, group_id)
      properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Kafka.OFFSET_RESET_CONFIG_EARLIEST)
    }

    properties

  }

}
