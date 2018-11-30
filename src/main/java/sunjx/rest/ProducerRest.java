package sunjx.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: sunjx
 * @Date: 2018/11/30 0030 14:27
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/send")
public class ProducerRest {

    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping("{msg}")
    public RestResult send(@PathVariable("msg") String msg){
        try {
            log.info("生产者 => msg: {}", msg);
            kafkaTemplate.send(TOPIC, msg);
            return RestResult.success(msg);
        } catch (Exception e) {
            log.error("异常信息 => ", e);
            return RestResult.fail(msg);
        }
    }
}
