package com.fsgame.chess.board;

import com.fsgame.chess.chesspiece.Piece;

import java.util.Deque;

/**
 * @Author: root
 * @Date: 2023/12/5 9:44
 * @Description:
 */
public interface Board {

    void updateBoard(int x, int y, Piece piece);

    Piece[][] getBoard();

    void addRecords(WalkingRecords walkingRecords);

    Deque<WalkingRecords> getRecords();
}
