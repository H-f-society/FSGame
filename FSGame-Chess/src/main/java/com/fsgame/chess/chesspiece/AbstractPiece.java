package com.fsgame.chess.chesspiece;

import com.fsgame.chess.board.Board;

/**
 * @Author: root
 * @Date: 2023/12/5 10:05
 * @Description:
 */
public abstract class AbstractPiece implements Piece {

    protected final Board board;

    public AbstractPiece(Board board) {
        this.board = board;
    }
}
