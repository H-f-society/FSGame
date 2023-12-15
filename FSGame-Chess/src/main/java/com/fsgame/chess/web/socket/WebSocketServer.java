package com.fsgame.chess.web.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsgame.chess.rule.chessboard.WalkingRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @Author: root
 * @Date: 2023/12/15 9:12
 * @Description:
 */
@ServerEndpoint("/websocketServer")
public class WebSocketServer extends TextWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 将收到的 JSON 转换为泛型对象
        Message<?> msg = convertToMyMessage(message, Message.class);

        // 处理消息
        handleMyMessage(msg, session);
    }

    private <T> Message<T> convertToMyMessage(TextMessage message, Class<T> valueType) throws JsonProcessingException {
        return (Message<T>) objectMapper.readValue(message.getPayload(), new ChessMessage().getClass());
    }

    private <T> void handleMyMessage(Message<T> msg, WebSocketSession session) {
        // 处理泛型消息
        T content = msg.getMessage();
        // 具体的处理逻辑...
    }
}
