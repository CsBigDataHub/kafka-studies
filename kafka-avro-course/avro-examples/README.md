# avro-examples

### Run GenericRecordExamples.java
```

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
{"first_name": "John", "last_name": "Doe", "age": 26, "height": 175.0, "weight": 70.5, "automated_email": false}
{"first_name": "John", "last_name": "Doe", "age": 26, "height": 175.0, "weight": 70.5, "automated_email": true}
Generic Record build did not succeed
org.apache.avro.AvroRuntimeException: Field first_name type:STRING pos:0 not set and has no default value
	at org.apache.avro.generic.GenericData.getDefaultValue(GenericData.java:1015)
	at org.apache.avro.data.RecordBuilderBase.defaultValue(RecordBuilderBase.java:138)
	at org.apache.avro.generic.GenericRecordBuilder.getWithDefault(GenericRecordBuilder.java:232)
	at org.apache.avro.generic.GenericRecordBuilder.build(GenericRecordBuilder.java:209)
	at com.github.simplesteph.avro.generic.GenericRecordExamples.main(GenericRecordExamples.java:67)
Written customer-generic.avro
Successfully read avro file
{"first_name": "John", "last_name": "Doe", "age": 26, "height": 175.0, "weight": 70.5, "automated_email": false}
First name: John
Non existent field: null

```

### mvn compile

![](image.png)
