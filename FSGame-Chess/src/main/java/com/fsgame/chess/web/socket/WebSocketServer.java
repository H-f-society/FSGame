package com.fsgame.chess.web.socket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @Author: root
 * @Date: 2023/12/15 9:12
 * @Description:
 */
@ServerEndpoint("/websocketServer")
public class WebSocketServer {

    @OnOpen
    public void onOpen(Session session) {

    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {

    }

    @OnMessage
    public void onMessage(Session session, Message message) {

    }
}
