package com.fsgame.chesswebonline.socket;

/**
 * @Author: root
 * @Date: 2023/12/15 11:25
 * @Description:
 */
public class ChessMessage<T> implements Message<T>{

    private T msg;

    public ChessMessage(T msg) {
        this.msg = msg;
    }

    @Override
    public T getMessage() {
        return msg;
    }

    public void setMessage(T msg) {
        this.msg = msg;
    }
}
