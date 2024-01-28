package com.fsgame.chesscore.chessboard;

import com.fsgame.chesscore.chesspiece.Piece;
import com.fsgame.chesscore.chesspiece.PieceMove;
import com.fsgame.chesscore.enums.BaseEnum;

import java.util.Deque;
import java.util.Map;

/**
 * @Author: root
 * @Date: 2023/12/5 9:44
 * @Description:
 */
public interface Board {

    /**
     * 获取当前角色类别，例如黑方或白方
     *
     * @return 返回当前主角色类别
     */
    BaseEnum getRoleEnum();

    /**
     * 坐标获取棋子
     *
     * @param coord 坐标
     * @return 返回棋子对象
     */
    Piece getPiece(int[] coord);

    /**
     * 坐标获取棋子
     *
     * @param x x坐标
     * @param y y坐标
     * @return 返回棋子对象
     */
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
