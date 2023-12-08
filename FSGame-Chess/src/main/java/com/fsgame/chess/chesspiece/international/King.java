package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chesspiece.international.movespecific.Castline;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.utils.DirectionUtil;

/**
 * @Author: root
 * @Date: 2023/12/4 15:01
 * @Description:
 */
public class King extends AbstractIntlChessPiece {

    public King(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    protected void initAllowDirection() {
        allowDirectionSet.clear();
        DirectionUtil.allDirection(allowDirectionSet);
    }

    @Override
    protected void initAllowMoveBehavior() {
        super.initAllowMoveBehavior();
        allowMoveBehaviorList.add(new Castline());
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.K;
    }

    @Override
    public boolean allowMove(int[] coord) {
        if (stepNum(coord) > 1) {
            return false;
        }
        return super.allowMove(coord);
    }

    /**
     * 王车易位
     * @return
     */
    private boolean castling() {
        return false;
    }
}
