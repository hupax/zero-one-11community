package com.zeroone.star.ws.comp;

import com.zeroone.star.project.dto.notify.SampleNotifyDTO;
import com.zeroone.star.ws.service.ChatServer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消息订阅组件
 */
@Slf4j
@Component
public class RmqReceive {
    
    @Resource
    ChatServer chat;
    
    @SneakyThrows
    @StreamListener(Sink.INPUT)
    public void receiveNotify(SampleNotifyDTO notify) {
        log.info("接收消息, {}", notify);
        chat.sendMessage(notify.getClientId(), notify);
    }
    
}
