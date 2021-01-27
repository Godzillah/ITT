import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProducerExampleHello {

    private static final Logger LOGGER = LogManager.getLogger(ProducerExampleHello.class);

    public static void main(String[] args) {

        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            String topicName = "prices";
            int i = 0;
            for (;;) {
                producer.send(new ProducerRecord<>(topicName, Integer.toString(i), Integer.toString(i)));
                System.out.println(("Producer sent message to topic:" +  topicName + " with -> key:" + Integer.toString(i) + " value:" + Integer.toString(i)));
                Thread.sleep(1000);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
