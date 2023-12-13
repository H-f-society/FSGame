package com.fsgame.chess.rule.chessboard;

import com.fsgame.chess.rule.chesspiece.Piece;
import com.fsgame.chess.rule.chesspiece.PieceMove;
import com.fsgame.chess.rule.enums.BaseEnum;

import java.util.Deque;
import java.util.Map;

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

    void swap(int[] source, int[] target);

    boolean unimpededRoute(int[] source, int[] target);

    boolean validRange(int[] coord);

    boolean validRange(int x, int y);

    Map<String, PieceMove> getPieceMoveBehavior();
}
