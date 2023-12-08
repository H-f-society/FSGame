package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chesspiece.PieceMove;
import com.fsgame.chess.chesspiece.international.movespecific.EnPassant;
import com.fsgame.chess.chesspiece.international.movespecific.Promotion;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.DirectionEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.utils.DirectionUtil;

/**
 * @Author: root
 * @Date: 2023/12/4 15:12
 * @Description:
 */
public class Pawn extends AbstractIntlChessPiece {

    public Pawn(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    protected void initAllowDirection() {
        allowDirectionSet.clear();
        allowDirectionSet.add(isMyPiece() ? DirectionEnum.UP : DirectionEnum.DOWN);
        allowDirectionSet.add(isMyPiece() ? DirectionEnum.LEFT_UP : DirectionEnum.LEFT_DOWN);
        allowDirectionSet.add(isMyPiece() ? DirectionEnum.RIGHT_UP : DirectionEnum.RIGHT_DOWN);
    }

    @Override
    protected void initAllowMoveBehavior() {
        allowMoveBehaviorList.clear();
        allowMoveBehaviorList.add(new Promotion());
        allowMoveBehaviorList.add(new EnPassant());
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.P;
    }

    @Override
    public boolean allowMove(int[] coord) {
        if ((stepCount == 0 && stepNum(coord) > 2) || (stepCount > 0 && stepNum(coord) > 1)) {
            return false;
        }
        super.allowMove(coord);
        return true;
    }

    @Override
    public BaseEnum move(int[] coord) {
        if (!super.allowMove(coord) || !this.allowMove(coord)) {
            return IntlBehaviorEnum.NOT_MOVE;
        }
        for (PieceMove pieceMove : allowMoveBehaviorList) {
            if (pieceMove.move(board, this.coord, coord)) {
                return pieceMove.getType();
            }
        }
        if (board.getPiece(coord) != null) {
            return IntlBehaviorEnum.NOT_MOVE;
        }
        // 前面吃子和吃过路兵条件都不满足，那只能向前移动了
        DirectionEnum dire = isMyPiece() ? DirectionEnum.UP : DirectionEnum.DOWN;
        if (dire.equals(DirectionUtil.calcDirection(this.coord, coord))) {
            board.swap(this.coord, coord);
            stepCount++;
            return IntlBehaviorEnum.MOVE;
        }
        return IntlBehaviorEnum.NOT_MOVE;
    }
}
