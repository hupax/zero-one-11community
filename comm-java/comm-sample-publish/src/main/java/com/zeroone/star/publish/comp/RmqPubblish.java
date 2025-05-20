package com.zeroone.star.publish.comp;


import com.zeroone.star.project.dto.notify.SampleNotifyDTO;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RmqPubblish {
    
    @Resource
    Source source;
    
    public boolean publishNotify(SampleNotifyDTO notify) {
        return source.output().send(MessageBuilder.withPayload(notify).build());
    }
    
}
