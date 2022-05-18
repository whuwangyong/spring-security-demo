package cn.whu.wy.usermanager.service;

import cn.whu.wy.usermanager.entity.OperationLog;
import cn.whu.wy.usermanager.mapper.IOperationLogMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


//@Component
@Slf4j
public class Receiver {
    @Autowired
    private Gson gson;

    @Autowired
    private IOperationLogMapper operationLogMapper;


    /**
     * 处理发到通信入口主题的消息
     *
     * @param record
     */
    @KafkaListener(topics = {"salary-adjustment"})
    public void process(ConsumerRecord<String, String> record) {
        OperationLog message = gson.fromJson(record.value(), OperationLog.class);
        log.info("received msg: {}", message);

        operationLogMapper.insertSelective(message);
    }
}
