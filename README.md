# AllKafkaProducers
There are 3 types of Kafka producers. 
1. Fire and Forget
  We publish a messsage to Kafka and we do not worry whether it reached or with the broker response.
2. Synchronous producer
  We send a message to Kafka and we wait for the broker response object. 
  We will use the response object to get the details of the offset, partition or ant errors.
  
3. Asynchronous producer
  We send a message to Kafka and we conitnue our workflow, when we recieve the response the callback function is executed.
