package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 21:01
 * @Description:
 */
public class EnPassnt extends AbstractIntlPieceMove {

    private static final IntlBehaviorEnum MOVE_BEHAVIOR = IntlBehaviorEnum.EN_PASSANT;

    @Override
    public IntlBehaviorEnum getType() {
        return MOVE_BEHAVIOR;
    }

    @Override
    public boolean move(Board board, int[] source, int[] target) {
        return false;
    }
}
