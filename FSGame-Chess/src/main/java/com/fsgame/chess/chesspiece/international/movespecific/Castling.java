package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.enums.international.IntlRoleEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 20:57
 * @Description:
 */
public class Castling extends AbstractIntlPieceMove {

    private static final IntlPieceEnum PIECE = IntlPieceEnum.K;

    public Castling() {
        super(IntlBehaviorEnum.CASTLING);
    }

    @Override
    public boolean move(Board board, int[] source, int[] target) {
        Piece sourcePiece = board.getPiece(source);
        Piece targetPiece = board.getPiece(target);
        if (PIECE.equals(sourcePiece.getType())) {
            return false;
        }
        BaseEnum role = sourcePiece.getRole();

        return true;
    }

    private boolean longCastling(Board board, int[] source, int[] target) {
        return true;
    }

    private boolean shortCastLing(Board board, int[] source, int[] target) {
        return true;
    }

}
