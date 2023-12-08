package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 20:14
 * @Description:
 */
public class Capture extends AbstractIntlPieceMove {

    protected static final IntlBehaviorEnum MOVE_BEHAVIOR = IntlBehaviorEnum.CAPTURE;

    @Override
    public IntlBehaviorEnum getType() {
        return MOVE_BEHAVIOR;
    }

    @Override
    public boolean move(Board board, int[] source, int[] target) {
        if (board.getPiece(source) != null && board.getPiece(target) != null) {
            board.swap(source, target);
            board.updateBoard(source, null);
            return true;
        }
        return false;
    }
}
