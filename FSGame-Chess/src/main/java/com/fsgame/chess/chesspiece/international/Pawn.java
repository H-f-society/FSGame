package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.enums.international.IntlRoleEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 15:12
 * @Description:
 */
public class Pawn extends AbstractPiece {

    public Pawn(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.P;
    }

    @Override
    public boolean allowMove(int[] coord) {
        return true;
    }

    @Override
    public BaseEnum move(int[] coord) {
        board.updateBoard(this.coord[0], this.coord[1], null);
        board.updateBoard(coord[0], coord[1], this);
        stepCount++;
        return IntlBehaviorEnum.MOVE;
    }
}
