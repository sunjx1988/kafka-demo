package sunjx.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: sunjx
 * @Date: 2018/11/30 0030 14:42
 * @Description:
 */
@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, ?> record){
        log.info("消费者 => topic: {}, offset: {}, key: {}, msg: {}", record.topic(), record.offset(), record.key(), record.value());
    }
}
