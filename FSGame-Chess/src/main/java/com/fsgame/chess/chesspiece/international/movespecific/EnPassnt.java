package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 21:01
 * @Description:
 */
public class EnPassnt extends AbstractPieceMove {

    private static final IntlBehaviorEnum MOVE_BEHAVIOR = IntlBehaviorEnum.EN_PASSANT;

    @Override
    public BaseEnum move(Board board, int[] source, int[] target) {
        return BASE_MOVE_BEHAVIOR;
    }
}
