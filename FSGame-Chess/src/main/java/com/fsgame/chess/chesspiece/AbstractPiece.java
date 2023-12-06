package com.fsgame.chess.chesspiece;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.DirectionEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: root
 * @Date: 2023/12/5 10:05
 * @Description:
 */
public abstract class AbstractPiece implements Piece {

    protected final Board board;

    protected final int[] coord;

    protected BaseEnum roleEnum;

    protected int stepCount;

    public AbstractPiece(Board board, int[] coord) {
        this.board = board;
        this.coord = coord;
    }

    @Override
    public boolean allowMove(int[] coord) {
        int x = coord[0];
        int y = coord[1];
        // 是否越界
        if (x < 0 || x > board.getBoard().length || y < 0 || y > board.getBoard()[0].length) {
            return false;
        }
        return !(this.coord[0] == x && this.coord[1] == y);
    }

    @Override
    public void setRole(BaseEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    @Override
    public int getStepCount() {
        return stepCount;
    }

    @Override
    public BaseEnum getRole() {
        return roleEnum;
    }

    @Override
    public String toString() {
        return (String) getType().getCode();
    }

    protected boolean isMyPiece() {
        return getRole().equals(board.getRoleEnum());
    }
}
