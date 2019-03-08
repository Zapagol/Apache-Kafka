name := "apache-kafka"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "0.10.1.0",
  "org.slf4j" % "slf4j-simple" % "1.7.25",
  "com.typesafe.play" % "play-json_2.11" % "2.4.2",
  "net.liftweb" %% "lift-json" % "3.0",
  "org.apache.avro" % "avro" % "1.7.0"
)