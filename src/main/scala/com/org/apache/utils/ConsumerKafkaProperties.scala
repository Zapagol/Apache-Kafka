package com.org.apache.utils

import java.util.Properties

import com.org.apache.constants.Kafka
import org.apache.kafka.clients.consumer.ConsumerConfig

object ConsumerKafkaProperties {

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

  def kafkaPropsForCustomDeserializer(): Properties = {

    val props = new Properties
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Kafka.BOOTSTRAPSERVERS)
    props.put(ConsumerConfig.GROUP_ID_CONFIG, Kafka.EMPLOYEE_GROUP_ID)
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, Kafka.STRING_KEY_DESERIALIZER)
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, Kafka.CUSTOM_DESERIALIZER)

    props
  }
}
