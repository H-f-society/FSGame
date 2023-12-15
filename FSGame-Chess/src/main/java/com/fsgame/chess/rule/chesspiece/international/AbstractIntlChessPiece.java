package com.fsgame.chess.rule.chesspiece.international;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chessboard.WalkingRecords;
import com.fsgame.chess.rule.chessboard.WalkingRecordsImpl;
import com.fsgame.chess.rule.chesspiece.AbstractPiece;
import com.fsgame.chess.rule.chesspiece.PieceMove;
import com.fsgame.chess.rule.enums.BaseEnum;
import com.fsgame.chess.rule.enums.DirectionEnum;
import com.fsgame.chess.rule.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.rule.utils.DirectionUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author: root
 * @Date: 2023/12/6 21:44
 * @Description:
 */
public abstract class AbstractIntlChessPiece extends AbstractPiece {

    protected Set<DirectionEnum> allowDirectionSet = new HashSet<>();

    protected List<PieceMove> allowMoveBehaviorList = new LinkedList<>();

    public AbstractIntlChessPiece(Board board, int[] coord) {
        super(board, coord);
        initAllowMoveBehavior();
    }

    protected abstract void initAllowDirection();

    protected void initAllowMoveBehavior() {
        allowMoveBehaviorList.add(board.getPieceMoveBehavior().get(IntlBehaviorEnum.CAPTURE.getCode()));
    }

    @Override
    public void updateCoord(int[] coord) {
        updateCoord(coord[0], coord[1]);
    }

    @Override
    public void updateCoord(int x, int y) {
        this.coord[0] = x;
        this.coord[1] = y;
    }

    @Override
    public void setRole(BaseEnum roleEnum) {
        super.setRole(roleEnum);
        initAllowDirection();
    }

    @Override
    public boolean allowMove(int[] coord) {
        DirectionEnum dire = DirectionUtil.calcDirection(this.coord, coord);
        // 如果目标点在可允许的移动方向上，并且路途上无障碍，允许移动
        return allowDirectionSet.contains(dire) && unimpededRoute(coord);
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
        WalkingRecords.Record pieceRecord = new WalkingRecords.RecordImpl(this, this.coord.clone(), coord.clone());
        board.swap(this.coord, coord);
        stepCount++;
        return new WalkingRecordsImpl.Builder()
                .record(pieceRecord)
                .behavior(IntlBehaviorEnum.MOVE)
                .build();
    }

    /**
     * 无障碍的路线
     * @return true or false
     */
    protected boolean unimpededRoute(int[] coord) {
        return board.unimpededRoute(this.coord, coord);
    }

    @Override
    public int stepNum(int[] coord) {
        return stepNum(this.coord, coord);
    }

    @Override
    public int stepNum(int[] source, int[] target) {
        int absX = Math.abs(target[0] - source[0]);
        int absY = Math.abs(target[1] - source[1]);
        if (absX == absY) {
            return absX;
        }
        if (absX == 0 || absY == 0) {
            return Math.max(absX, absY);
        }
        return 1;
    }

}
