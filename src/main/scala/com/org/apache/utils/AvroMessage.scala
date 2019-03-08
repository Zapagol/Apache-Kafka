package com.org.apache.utils

import java.io.ByteArrayOutputStream

import org.apache.avro
import org.apache.avro.Schema
import org.apache.avro.file.CodecFactory
import org.apache.avro.generic.{GenericDatumWriter, GenericRecord}

// TODO: The Parameters will come from the config file ,we need to refactor this part.
class AvroMessage(avroJsonSchema: String) {

  val parser = new Schema.Parser()
  val schema = parser.parse(avroJsonSchema)
  val baos = new ByteArrayOutputStream()
  val gdw = new GenericDatumWriter[GenericRecord](schema)
  val dfw = new avro.file.DataFileWriter[GenericRecord](gdw)
  val compressionLevel = 5
  dfw.setCodec(CodecFactory.deflateCodec(compressionLevel))
  dfw.create(schema, baos)
}
