package com.fsgame.chess.chesspiece;

import com.fsgame.chess.board.Board;

/**
 * @Author: root
 * @Date: 2023/12/5 10:05
 * @Description:
 */
public abstract class AbstractPiece implements Piece {

    protected final Board board;

    protected final int[] coord;

    public AbstractPiece(Board board, int[] coord) {
        this.board = board;
        this.coord = coord;
    }
}
