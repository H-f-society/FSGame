package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.international.IntlPieceEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 21:02
 * @Description:
 */
public class PawnCature extends Capture {


    @Override
    public boolean move(Board board, int[] source, int[] target) {

        return true;
    }
}
