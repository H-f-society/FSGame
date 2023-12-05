package com.fsgame.chess.board.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.board.WalkingRecords;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.utils.IntlChessUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: root
 * @Date: 2023/12/4 15:47
 * @Description:
 */
public class IntlChessBoard implements Board {

    private final Piece[][] board = new Piece[8][8];

    private final Deque<WalkingRecords> walkingRecordsStack = new LinkedList<>();

    public IntlChessBoard() {
        initPiece(IntlChessUtil.getWhitePieceInitCoord());
        initPiece(IntlChessUtil.getBlackPieceInitCoord());
    }

    private void initPiece(Map<IntlPieceEnum, int[][]> coordsMap) {
        for (Map.Entry<IntlPieceEnum, int[][]> entry : coordsMap.entrySet()) {
            IntlPieceEnum pieceEnum = entry.getKey();
            initPiece(pieceEnum, coordsMap.get(pieceEnum));
        }
    }

    private void initPiece(IntlPieceEnum pieceEnum, int[][] coords) {
        try {
            for (int[] coord : coords) {

                // 使用反射加载类
                Class<?> clazz = Class.forName(IntlChessUtil.PACKER_PATH + pieceEnum.getCode());

                // 获取带有参数的构造函数
                Constructor<?> constructor = clazz.getDeclaredConstructor(Board.class, int[].class);

                // 使用反射创建类的实例并传递参数
                Piece piece = (Piece) constructor.newInstance(this, coord);

                updateBoard(coord[0], coord[1], piece);
            }

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
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
