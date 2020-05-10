package com.ccp.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(value = Sink.class)
@Slf4j
public class ReceiveMessageListenerService {

    @Value(value = "${server.port}")
    private String serverPort;


    @StreamListener(value = Sink.INPUT)
    public void input(Message<String> message){
        log.info("\n接收到的消息为："+message.getPayload()+"\t 端口："+serverPort);
    }

}
