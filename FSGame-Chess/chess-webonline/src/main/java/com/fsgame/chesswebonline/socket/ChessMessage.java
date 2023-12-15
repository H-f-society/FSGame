package com.fsgame.chesswebonline.socket;

import com.fsgame.chesscore.chessboard.WalkingRecords;

/**
 * @Author: root
 * @Date: 2023/12/15 11:25
 * @Description:
 */
public class ChessMessage implements Message<WalkingRecords>{
    @Override
    public WalkingRecords getMessage() {
        return null;
    }

    @Override
    public void setMessage(WalkingRecords message) {

    }
}
