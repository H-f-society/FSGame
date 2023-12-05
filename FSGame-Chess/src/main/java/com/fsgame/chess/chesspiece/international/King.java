package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;

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
        int absX = Math.abs(this.coord[0] - coord[0]);
        int absY = Math.abs(this.coord[1] - coord[1]);
        if (Math.abs(absX - absY) > 1) {
            return false;
        }
        return true;
    }

    @Override
    public BaseEnum move(int[] coord) {
        if (!super.allowMove(coord) || !allowMove(coord)) {
            return IntlBehaviorEnum.NOT_MOVE;
        }

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
