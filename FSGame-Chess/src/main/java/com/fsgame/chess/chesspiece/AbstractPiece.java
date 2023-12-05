package com.fsgame.chess.chesspiece;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.enums.BaseEnum;

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
        return !(this.coord[0] == coord[0] && this.coord[1] == coord[1]);
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
