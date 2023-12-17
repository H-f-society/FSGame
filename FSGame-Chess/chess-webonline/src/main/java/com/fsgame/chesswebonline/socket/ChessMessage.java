package com.fsgame.chesswebonline.socket;

import com.fsgame.chesscore.chessboard.WalkingRecords;

/**
 * @Author: root
 * @Date: 2023/12/15 11:25
 * @Description:
 */
public class ChessMessage implements Message<WalkingRecords>{

    private WalkingRecords walkingRecords;

    public ChessMessage(WalkingRecords walkingRecords) {
        this.walkingRecords = walkingRecords;
    }

    @Override
    public WalkingRecords getMessage() {
        return walkingRecords;
    }

    @Override
    public void setMessage(WalkingRecords walkingRecords) {
        this.walkingRecords = walkingRecords;
    }
}
