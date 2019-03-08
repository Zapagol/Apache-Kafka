package com.org.apache.constants

object Kafka {

  //Common Properties
  lazy val BOOTSTRAPSERVERS = "localhost:9092"

  //Producer Properties
  lazy val STRING_KEY_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer"
  lazy val STRING_VALUE_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer"
  lazy val BYTEARRAY_VALUE_SERIALIZER = "org.apache.kafka.common.serialization.ByteArraySerializer"

  //Consumer Properties
  lazy val STRING_KEY_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer"
  lazy val STRING_VALUE_DESERIALIZER = "org.apache.kafka.common.serialization.StringDeserializer"
  lazy val OFFSET_RESET_CONFIG_EARLIEST = "earliest"
  lazy val OFFSET_RESET_CONFIG_LATEST = "latest"

  //Topic Names
  lazy val FIRST_TOPIC = "first_topic"
  lazy val EMPLOYEE_TOPIC = "employee_topic"

  //Group Id's
  lazy val GROUP_ID_1 = "first_group_id"
  lazy val GROUP_ID_2 = "second_group_id"
  lazy val GROUP_ID_3 = "third_group_id"
  lazy val EMPLOYEE_GROUP_ID = "employee_group_id"

  //Custom Partition
  lazy val COUNTRY_PARTIOTIONER_CLASS_PATH = "apache.kafka.scala.utils.CountryPartitioner"
  lazy val PARTITION_ZERO_COUNTRY_NAME = "country.name"
  lazy val PARTITION_ZERO_COUNTRY_NAME_VALUE = "INDIA"

  //Custom Serialzer and Deserializer
  lazy val CUSTOM_SERIALIZER = "apache.kafka.scala.utils.CustomSerializer"
  lazy val CUSTOM_DESERIALIZER = "apache.kafka.scala.utils.CustomDeserializer"
}
