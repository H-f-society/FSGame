package com.fsgame.chesswebonline.config;

import com.fsgame.chesswebonline.socket.WebSocketServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Author: root
 * @Date: 2023/12/15 9:09
 * @Description:
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketServer(), "/websocket").setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler webSocketServer() {
        return (WebSocketHandler) new WebSocketServer();
    }

}
