package com.fsgame.chesscore.chesspiece;

import com.fsgame.chesscore.chessboard.Board;
import com.fsgame.chesscore.chessboard.WalkingRecords;

/**
 * @Author: root
 * @Date: 2023/12/7 20:08
 * @Description:
 */
public interface PieceMove {

    WalkingRecords move(Board board, int[] source, int[] target);

    void repentance(WalkingRecords walkingRecords);

}
