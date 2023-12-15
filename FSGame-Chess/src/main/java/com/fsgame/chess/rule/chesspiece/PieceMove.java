package com.fsgame.chess.rule.chesspiece;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chessboard.WalkingRecords;

/**
 * @Author: root
 * @Date: 2023/12/7 20:08
 * @Description:
 */
public interface PieceMove {

    WalkingRecords move(Board board, int[] source, int[] target);

    void repentance(WalkingRecords walkingRecords);

}
