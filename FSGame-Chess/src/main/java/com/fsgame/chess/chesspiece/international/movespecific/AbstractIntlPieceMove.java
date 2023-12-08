package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.WalkingRecords;
import com.fsgame.chess.chesspiece.PieceMove;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 20:54
 * @Description:
 */
public abstract class AbstractIntlPieceMove implements PieceMove {
    private IntlBehaviorEnum moveBehavior;

    public AbstractIntlPieceMove() {
        this(IntlBehaviorEnum.MOVE);
    }

    public AbstractIntlPieceMove(IntlBehaviorEnum moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    @Override
    public IntlBehaviorEnum getType() {
        return moveBehavior;
    }

    protected void setMoveBehavior(IntlBehaviorEnum intlBehaviorEnum) {
        this.moveBehavior = intlBehaviorEnum;
    }

    @Override
    public void repentance(WalkingRecords walkingRecords) {

    }

}
