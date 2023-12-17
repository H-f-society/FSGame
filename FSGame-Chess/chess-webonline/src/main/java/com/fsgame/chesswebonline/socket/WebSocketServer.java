package com.fsgame.chesswebonline.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: root
 * @Date: 2023/12/15 9:12
 * @Description:
 */
@ServerEndpoint("/websocket/{sessionId}")
@Component
public class WebSocketServer {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private static final CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;
    private String sessionId;

    @OnOpen
    public void onOpen(Session session, @PathParam("sessionId") String sessionId) {
        this.session = session;
        this.sessionId = sessionId;
        webSocketSet.add(this);
        logger.info("有新连接加入，当前在线人数为：{}", webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        logger.info("有连接关闭，当前在线人数为：{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        logger.info("收到客户端消息：{}", message);
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("发生错误", error);
    }

    private void broadcast(String message) {
        for (WebSocketServer client : webSocketSet) {
            try {
                // 使用相同的sessionId或其他标识符判断是否属于同一组
                if (this.sessionId.equals(client.sessionId)) {
                    client.session.getBasicRemote().sendText(message);
                }
            } catch (IOException e) {
                logger.error("发生错误", e);
            }
        }
    }
}