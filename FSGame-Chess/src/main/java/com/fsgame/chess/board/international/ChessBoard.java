package com.fsgame.chess.board.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.board.WalkingRecords;
import com.fsgame.chess.chesspiece.Piece;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: root
 * @Date: 2023/12/4 15:47
 * @Description:
 */
public class ChessBoard implements Board {

    private final Piece[][] board = new Piece[8][8];

    private final Deque<WalkingRecords> walkingRecordsStack = new LinkedList<>();

    public ChessBoard() {

    }

    @Override
    public void updateBoard(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    @Override
    public Piece[][] getBoard() {
        return board;
    }

    @Override
    public void addRecords(WalkingRecords walkingRecords) {
        walkingRecordsStack.add(walkingRecords);
    }

    @Override
    public Deque<WalkingRecords> getRecords() {
        return walkingRecordsStack;
    }
}
