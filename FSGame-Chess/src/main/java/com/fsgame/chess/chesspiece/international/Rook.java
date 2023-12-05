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
public class Rook extends AbstractPiece {

    public Rook(Board board) {
        super(board);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.R;
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
}
