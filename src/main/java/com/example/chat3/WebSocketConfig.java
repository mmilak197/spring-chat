package com.example.chat3;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // definiujemy gdzie nasze wiadomosci maja trafic - nazwa mojego brokera
        registry.setApplicationDestinationPrefixes("/app"); //miejsce do którego trzeba się odwolac aby dostac sie do naszej kolejki,
        // jeśli odwolujemy sie z zewnetrznej applikacji u nas uzyjemy tego dopołaczenia się z poziomu javascriptu
    }
}
