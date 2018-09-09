# Learning


### run this from our project folder. Make sure ~/avro-tools-1.8.2.jar is your actual avro tools location
````
$ java -jar avro-tools-1.8.2.jar tojson --pretty customer-generic.avro
log4j:WARN No appenders could be found for logger (org.apache.hadoop.metrics2.lib.MutableMetricsFactory).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
{
  "first_name" : "John",
  "last_name" : "Doe",
  "age" : 26,
  "height" : 175.0,
  "weight" : 70.5,
  "automated_email" : false
}

````
 
```
$ java -jar avro-tools-1.8.2.jar tojson --pretty customer-specific.avro
log4j:WARN No appenders could be found for logger (org.apache.hadoop.metrics2.lib.MutableMetricsFactory).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
{
  "first_name" : "Mark",
  "last_name" : "Simpson",
  "age" : 30,
  "height" : 180.0,
  "weight" : 90.0,
  "automated_email" : true
}
 
```

# getting the schema
```
$ java -jar avro-tools-1.8.2.jar getschema customer-specific.avro

log4j:WARN No appenders could be found for logger (org.apache.hadoop.metrics2.lib.MutableMetricsFactory).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
{
  "type" : "record",
  "name" : "Customer",
  "namespace" : "com.example",
  "fields" : [ {
    "name" : "first_name",
    "type" : {
      "type" : "string",
      "avro.java.string" : "String"
    },
    "doc" : "First Name of Customer"
  }, {
    "name" : "last_name",
    "type" : {
      "type" : "string",
      "avro.java.string" : "String"
    },
    "doc" : "Last Name of Customer"
  }, {
    "name" : "age",
    "type" : "int",
    "doc" : "Age at the time of registration"
  }, {
    "name" : "height",
    "type" : "float",
    "doc" : "Height at the time of registration in cm"
  }, {
    "name" : "weight",
    "type" : "float",
    "doc" : "Weight at the time of registration in kg"
  }, {
    "name" : "automated_email",
    "type" : "boolean",
    "doc" : "Field indicating if the user is enrolled in marketing emails",
    "default" : true
  } ]
}

```
 
#### tojson --pretty customer-reflected.avro

```
$ java -jar avro-tools-1.8.2.jar tojson --pretty customer-reflected.avro 
log4j:WARN No appenders could be found for logger (org.apache.hadoop.metrics2.lib.MutableMetricsFactory).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
{
  "firstName" : "Bill",
  "lastName" : "Clark",
  "nickName" : {
    "string" : "The Rocket"
  }
}
MacBook-Air-de-David:kafka-avro-course davidpetro$ 

```
 
