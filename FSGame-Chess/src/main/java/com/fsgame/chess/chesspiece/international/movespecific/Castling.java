package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 20:57
 * @Description:
 */
public class Castling extends AbstractIntlPieceMove {

    private static final IntlBehaviorEnum MOVE_BEHAVIOR = IntlBehaviorEnum.CASTLING;

    @Override
    public IntlBehaviorEnum getType() {
        return MOVE_BEHAVIOR;
    }

    @Override
    public boolean move(Board board, int[] source, int[] target) {
        Piece sourcePiece = board.getPiece(source);
        Piece targetPiece = board.getPiece(target);
        if (IntlPieceEnum.K.equals(sourcePiece.getType())) {
            return false;
        }

        return true;
    }

    private boolean longCastling(Board board, int[] source, int[] target) {
        return true;
    }

    private boolean shortCastLing(Board board, int[] source, int[] target) {
        return true;
    }

}
