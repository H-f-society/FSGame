package com.fsgame.chess.rule.chesspiece.international;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chessboard.WalkingRecords;
import com.fsgame.chess.rule.chesspiece.AbstractPiece;
import com.fsgame.chess.rule.chesspiece.Piece;
import com.fsgame.chess.rule.chesspiece.PieceMove;
import com.fsgame.chess.rule.chesspiece.international.movespecific.Capture;
import com.fsgame.chess.rule.enums.BaseEnum;
import com.fsgame.chess.rule.enums.DirectionEnum;
import com.fsgame.chess.rule.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.rule.enums.international.IntlRoleEnum;
import com.fsgame.chess.rule.utils.DirectionUtil;

import java.util.*;

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
        allowMoveBehaviorList.add(new Capture());
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
        // 黑白先后顺序判定，取决于历史记录（这段先注释，测试完在放开）
        if (board.getRecords().isEmpty() && IntlRoleEnum.B.equals(board.getRoleEnum())) {
            return false;
        }
        if (!board.getRecords().isEmpty()) {
            WalkingRecords walkingRecords = board.getRecords().getLast();
            Piece lastPiece = walkingRecords.getPiece();
            if (lastPiece.getRole().equals(getRole())) {
                return false;
            }
        }

        DirectionEnum dire = DirectionUtil.calcDirection(this.coord, coord);
        // 如果目标点在可允许的移动方向上，并且路途上无障碍，允许移动
        return allowDirectionSet.contains(dire) && unimpededRoute(coord);
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
        board.swap(this.coord, coord);
        stepCount++;
        return IntlBehaviorEnum.MOVE;
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
