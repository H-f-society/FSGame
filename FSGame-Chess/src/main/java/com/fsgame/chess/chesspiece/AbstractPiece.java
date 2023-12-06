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
        return validRange(coord) && !(this.coord[0] == coord[0] && this.coord[1] == coord[10]);
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

    protected boolean validRange(int[] coord) {
        return validRange(coord[0], coord[1]);
    }

    protected boolean validRange(int x, int y) {
        return x > 0 && y > 0 && x < board.getBoard().length && y < board.getBoard()[0].length;
    }
}
