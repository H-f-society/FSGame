package com.fsgame.chesscore.chesspiece.international;

import com.fsgame.chesscore.chessboard.Board;
import com.fsgame.chesscore.chessboard.WalkingRecords;
import com.fsgame.chesscore.chessboard.WalkingRecordsImpl;
import com.fsgame.chesscore.chesspiece.PieceMove;
import com.fsgame.chesscore.chesspiece.international.movespecific.EnPassant;
import com.fsgame.chesscore.chesspiece.international.movespecific.Promotion;
import com.fsgame.chesscore.enums.BaseEnum;
import com.fsgame.chesscore.enums.DirectionEnum;
import com.fsgame.chesscore.enums.international.IntlBehaviorEnum;
import com.fsgame.chesscore.enums.international.IntlPieceEnum;
import com.fsgame.chesscore.utils.DirectionUtil;

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
        allowMoveBehaviorList.add(board.getPieceMoveBehavior().get(IntlBehaviorEnum.PROMOTION.getCode()));
        allowMoveBehaviorList.add(board.getPieceMoveBehavior().get(IntlBehaviorEnum.EN_PASSANT.getCode()));
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
    public WalkingRecords move(int[] coord) {
        if (!super.allowMove(coord) || !this.allowMove(coord)) {
            return null;
        }
        for (PieceMove pieceMove : allowMoveBehaviorList) {
            WalkingRecords walkingRecords = pieceMove.move(board, this.coord, coord);
            if (walkingRecords != null) {
                return walkingRecords;
            }
        }
        if (board.getPiece(coord) != null) {
            return null;
        }
        // 前面吃子和吃过路兵条件都不满足，那只能向前移动了
        DirectionEnum dire = isMyPiece() ? DirectionEnum.UP : DirectionEnum.DOWN;
        if (dire.equals(DirectionUtil.calcDirection(this.coord, coord))) {
            WalkingRecords.Record pawnRecord = new WalkingRecords.RecordImpl(this, this.coord.clone(), coord.clone());
            board.swap(this.coord, coord);
            stepCount++;
            return new WalkingRecordsImpl.Builder()
                    .record(pawnRecord)
                    .behavior(IntlBehaviorEnum.MOVE)
                    .build();
        }
        return null;
    }
}
