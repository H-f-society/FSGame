package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 21:02
 * @Description:
 */
public class PawnCature extends Capture {

    @Override
    public BaseEnum move(Board board, int[] source, int[] target) {
        if (board.getPiece(source) != null && board.getPiece(target) != null) {
            return MOVE_BEHAVIOR;
        }
        return BASE_MOVE_BEHAVIOR;
    }
}
