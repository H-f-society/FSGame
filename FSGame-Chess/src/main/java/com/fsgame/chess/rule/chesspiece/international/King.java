package com.fsgame.chess.rule.chesspiece.international;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chesspiece.PieceMove;
import com.fsgame.chess.rule.chesspiece.international.movespecific.Castling;
import com.fsgame.chess.rule.enums.BaseEnum;
import com.fsgame.chess.rule.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.rule.enums.international.IntlPieceEnum;
import com.fsgame.chess.rule.utils.DirectionUtil;

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
        allowMoveBehaviorList.add(new Castling());
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.K;
    }

    @Override
    public BaseEnum move(int[] coord) {
        if (!super.allowMove(coord)) {
            return IntlBehaviorEnum.NOT_MOVE;
        }
        for (PieceMove pieceMove : allowMoveBehaviorList) {
            if (pieceMove.move(board, this.coord, coord)) {
                return pieceMove.getType();
            }
        }
        board.swap(this.coord, coord);
        stepCount++;
        return IntlBehaviorEnum.MOVE;
    }

    /**
     * 王车易位
     * @return
     */
    private boolean castling() {
        return false;
    }
}