package com.org.apache.utils

import java.util

import org.apache.kafka.clients.producer.Partitioner
import org.apache.kafka.common.Cluster

class CountryPartitioner extends Partitioner {

  private var countryName = "";

  /**
    * This method will get called at the start, you should use it to do one time startup activity
    *
    * @param configs
    */
  override def configure(configs: util.Map[String, _]): Unit = {
    countryName = configs.get("country.name").toString
  }

  /**
    * This method get called once for each message.
    *
    * @param topic
    * @param key
    * @param keyBytes
    * @param value
    * @param valueBytes
    * @param cluster
    * @return Partition number Int
    */
  override def partition(topic: String, key: Any, keyBytes: Array[Byte],
                         value: Any, valueBytes: Array[Byte], cluster: Cluster): Int = {

    //Assigns the partitions to the messages based on the country name
    countryName match {
      case "INDIA" => 0
    }
  }

  /**
    * This method will get called at the end and
    * gives your partitioner class chance to cleanup
    */
  override def close(): Unit = {}
}
