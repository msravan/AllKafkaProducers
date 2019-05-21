import java.util.Properties
import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

object ScalaASyncProducer extends App {

  val events = args(0).toInt
  val topic = args(1)
  val brokers = args(2)

  val props = new Properties()
  props.put("bootstrap.servers", brokers)
  props.put("client.id", "ScalaProducerExample")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val key = "id"
  val value = "User_"+ System.nanoTime()
  val producer = new KafkaProducer[String, String](props)
  val producerRecord = new ProducerRecord[String,String](topic,"s","test_Value")

  try {
    producer.send(producerRecord, new myProducerCallBack())
  }
  catch {
    case e: Exception => e.printStackTrace
  }
  producer.close()

  class myProducerCallBack extends Callback() {
    override def onCompletion(metadata: RecordMetadata, e: Exception): Unit = {
      if (e != null) e.printStackTrace
    }
  }
}

