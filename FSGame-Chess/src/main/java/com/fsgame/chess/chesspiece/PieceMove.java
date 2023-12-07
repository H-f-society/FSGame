package com.fsgame.chess.chesspiece;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chessboard.WalkingRecords;
import com.fsgame.chess.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 20:08
 * @Description:
 */
public interface PieceMove {

    BaseEnum move(Board board, int[] source, int[] target);

    void repentance(WalkingRecords walkingRecords);

}
