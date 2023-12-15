package com.fsgame.chesswebonline.socket;

/**
 * @Author: root
 * @Date: 2023/12/15 9:24
 * @Description:
 */
public interface Message<T> {

    T getMessage();

    void setMessage(T message);
}
