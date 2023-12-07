package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 20:57
 * @Description:
 */
public class Castline extends AbstractIntlPieceMove {

    private static final IntlBehaviorEnum MOVE_BEHAVIOR = IntlBehaviorEnum.CASTLING;

    @Override
    public BaseEnum move(Board board, int[] source, int[] target) {
        return BASE_MOVE_BEHAVIOR;
    }

}
