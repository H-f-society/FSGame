package com.fsgame.chess.chessboard;

import com.fsgame.chess.chesspiece.Piece;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: root
 * @Date: 2023/12/4 15:47
 * @Description:
 */
public class ChessBoard {

    private final Piece[][] board = new Piece[8][8];

    private final Deque<WalkingRecords> walkingRecordsQueue = new LinkedList<>();

    public ChessBoard() {

    }
}
