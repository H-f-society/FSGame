package com.fsgame.chess.rule.chesspiece.international.movespecific;

import com.fsgame.chess.rule.chessboard.WalkingRecords;
import com.fsgame.chess.rule.chesspiece.PieceMove;
import com.fsgame.chess.rule.enums.international.IntlBehaviorEnum;

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
