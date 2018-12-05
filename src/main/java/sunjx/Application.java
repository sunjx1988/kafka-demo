package sunjx;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @Auther: sunjx
 * @Date: 2018/11/30 0030 14:24
 * @Description:
 */
@Slf4j
@EnableAsync
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private Random random;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        random.random();
    }
}

@Slf4j
@Component
class Random{

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private static final String TOPIC = "random";

    @Async
    public void random(){
        String random ;
        while (true){
            random = String.valueOf((int)(Math.random() * 100)) + "," + System.currentTimeMillis();
            log.info("random => {}" , random);
            kafkaTemplate.send(TOPIC, random);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

@Slf4j
@Component
class AvgResult{

    @KafkaListener(topics = "random_out")
    public void listen(ConsumerRecord<?, ?> record){
        log.info("消费者 => topic: {}, offset: {}, key: {}, msg: {}", record.topic(), record.offset(), record.key(), record.value());
    }
}
