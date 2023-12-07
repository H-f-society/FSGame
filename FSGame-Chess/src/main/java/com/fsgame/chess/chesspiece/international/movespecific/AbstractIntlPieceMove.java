package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.WalkingRecords;
import com.fsgame.chess.chesspiece.PieceMove;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 20:54
 * @Description:
 */
public abstract class AbstractIntlPieceMove implements PieceMove {

    protected static final IntlBehaviorEnum BASE_MOVE_BEHAVIOR = IntlBehaviorEnum.MOVE;

    @Override
    public void repentance(WalkingRecords walkingRecords) {

    }
}
