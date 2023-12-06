package com.fsgame.chess.board.international;

import com.fsgame.chess.board.Behavior;
import com.fsgame.chess.board.Board;
import com.fsgame.chess.board.WalkingRecords;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.enums.international.IntlRoleEnum;
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

    private IntlRoleEnum roleEnum;

    private final Piece[][] board = new Piece[8][8];

    private final Deque<WalkingRecords> walkingRecordsStack = new LinkedList<>();

    public IntlChessBoard() {
        this(IntlRoleEnum.W);
    }

    public IntlChessBoard(IntlRoleEnum roleEnum) {
        this.roleEnum = roleEnum;
        initPiece(IntlChessUtil.getMySelfPieceInitCoord(roleEnum), roleEnum);
        initPiece(IntlChessUtil.getOpponentPieceInitCoord(roleEnum), IntlRoleEnum.W.equals(roleEnum) ? IntlRoleEnum.B : IntlRoleEnum.W);
    }

    private void initPiece(Map<IntlPieceEnum, int[][]> coordsMap, IntlRoleEnum roleEnum) {
        for (Map.Entry<IntlPieceEnum, int[][]> entry : coordsMap.entrySet()) {
            IntlPieceEnum pieceEnum = entry.getKey();
            initPiece(pieceEnum, coordsMap.get(pieceEnum), roleEnum);
        }
    }

    private void initPiece(IntlPieceEnum pieceEnum, int[][] coords, IntlRoleEnum roleEnum) {
        try {
            for (int[] coord : coords) {

                // 使用反射加载类
                Class<?> clazz = Class.forName(IntlChessUtil.PACKER_PATH + pieceEnum.getCode());

                // 获取带有参数的构造函数
                Constructor<?> constructor = clazz.getDeclaredConstructor(Board.class, int[].class);

                // 使用反射创建类的实例并传递参数
                Piece piece = (Piece) constructor.newInstance(this, coord);
                piece.setRole(roleEnum);

                updateBoard(coord[0], coord[1], piece);
            }

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BaseEnum<String> getRoleEnum() {
        return roleEnum;
    }

    @Override
    public void updateBoard(int[] coord, Piece piece) {
        updateBoard(coord[0], coord[1], piece);
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

    @Override
    public boolean move(int[] source, int[] target) {
        Piece piece = board[source[0]][source[1]];
        Piece targetPiece = board[target[0]][target[1]];
        if (piece == null) {
            return false;
        }

        BaseEnum<?> behaviorEnum = piece.move(target);
        if (IntlBehaviorEnum.NOT_MOVE.equals(behaviorEnum)) {
            return false;
        }
        WalkingRecords walkingRecords = new WalkingRecords.Builder()
                .source(source)
                .target(target)
                .piece(piece)
                .behavior(new Behavior(piece, targetPiece, behaviorEnum))
                .build();
        walkingRecordsStack.add(walkingRecords);
        return true;
    }
}
