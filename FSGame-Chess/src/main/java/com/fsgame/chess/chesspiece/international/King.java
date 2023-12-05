package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.enums.international.IntlRoleEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 15:01
 * @Description:
 */
public class King extends AbstractPiece {

    public King(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.K;
    }

    @Override
    public boolean allowMove(int[] coord) {
        return false;
    }

    @Override
    public BaseEnum move(int[] coord) {
        return null;
    }

    /**
     * 王车易位
     * @return
     */
    private boolean castling() {
        return false;
    }
}
