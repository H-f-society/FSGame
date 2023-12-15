package com.fsgame.chess.web.socket;

import com.fsgame.chess.rule.chessboard.WalkingRecords;

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
