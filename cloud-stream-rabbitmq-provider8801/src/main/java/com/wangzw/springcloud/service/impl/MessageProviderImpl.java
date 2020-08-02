package com.wangzw.springcloud.service.impl;

import com.wangzw.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import sun.misc.MessageUtils;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: wangzw
 * @date: 2020-08-01 12:11
 **/
@EnableBinding(Source.class)//定义消息推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; //消息发送管道


    @Override
    public String send() {
        String id = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(id).build());
        return null;
    }
}
