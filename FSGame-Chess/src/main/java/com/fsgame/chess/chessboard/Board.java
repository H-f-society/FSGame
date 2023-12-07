package com.fsgame.chess.chessboard;

import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.BaseEnum;

import java.util.Deque;

/**
 * @Author: root
 * @Date: 2023/12/5 9:44
 * @Description:
 */
public interface Board {

    BaseEnum getRoleEnum();

    Piece getPiece(int[] coord);

    Piece getPiece(int x, int y);

    void updateBoard(int[] coord, Piece piece);

    void updateBoard(int x, int y, Piece piece);

    Piece[][] getBoard();

    void addRecords(WalkingRecords walkingRecords);

    Deque<WalkingRecords> getRecords();

    boolean move(int[] source, int[] target);

    int rows();

    int columns();
}
