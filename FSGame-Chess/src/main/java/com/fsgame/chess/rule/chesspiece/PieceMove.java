package com.fsgame.chess.rule.chesspiece;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chessboard.WalkingRecords;
import com.fsgame.chess.rule.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 20:08
 * @Description:
 */
public interface PieceMove {

    BaseEnum getType();

    boolean move(Board board, int[] source, int[] target);

    void repentance(WalkingRecords walkingRecords);

}
