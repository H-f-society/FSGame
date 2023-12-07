package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.chesspiece.PieceMove;
import com.fsgame.chess.chesspiece.international.movespecific.Capture;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.DirectionEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.utils.DirectionUtil;

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
        // 如果目标格子上的棋子和当前格子上的棋子为同一色，不允许移动
        Piece targetPiece = board.getPiece(coord);
        if (targetPiece != null && getRole().equals(targetPiece.getRole())) {
            return false;
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
        board.updateBoard(this.coord[0], this.coord[1], null);
        board.updateBoard(coord[0], coord[1], this);
        stepCount++;
        return IntlBehaviorEnum.MOVE;
    }

    /**
     * 无障碍的路线
     * @return true or false
     */
    protected boolean unimpededRoute(int[] coord) {
        return unimpededRoute(coord[0], coord[1]);
    }

    protected boolean unimpededRoute(int x, int y) {
        // x,y轴移动的方向(-1, 0, 1)
        int direX = Integer.compare(x - this.coord[0], 0);
        int direY = Integer.compare(y - this.coord[1], 0);

        int tempX = this.coord[0];
        int tempY = this.coord[1];
        while(validRange(tempX, tempY)) {
            tempX += direX;
            tempY += direY;
            if (tempX == x && tempY == y) {
                break;
            }
            if (board.getPiece(tempX, tempY) != null) {
                return false;
            }
        }
        return true;
    }

    protected int stepNum(int[] coord) {
        return stepNum(coord[0], coord[1]);
    }

    // 间隔步数（格子）
    protected int stepNum(int x, int y) {
        int absX = Math.abs(this.coord[0] - x);
        int absY = Math.abs(this.coord[1] - y);
        if (absX == absY) {
            return absX;
        }
        if (absX == 0 || absY == 0) {
            return Math.max(absX, absY);
        }
        return 1;
    }

}
