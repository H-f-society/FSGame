package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.enums.international.IntlRoleEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 15:12
 * @Description:
 */
public class Knight extends AbstractPiece {

    public Knight(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.N;
    }

    @Override
    public IntlRoleEnum getRole() {
        return null;
    }

    @Override
    public int StepCount() {
        return 0;
    }

    @Override
    public int[] initCoord() {
        return new int[0];
    }

    @Override
    public boolean allowMove(int[] coord) {
        return false;
    }

    @Override
    public boolean move(int[] coord) {
        return false;
    }
}
