package com.fsgame.chesscore.chessboard.international;

import com.fsgame.chesscore.chessboard.Board;
import com.fsgame.chesscore.chessboard.WalkingRecords;
import com.fsgame.chesscore.chesspiece.Piece;
import com.fsgame.chesscore.chesspiece.PieceMove;
import com.fsgame.chesscore.enums.BaseEnum;
import com.fsgame.chesscore.enums.international.IntlBehaviorEnum;
import com.fsgame.chesscore.enums.international.IntlRoleEnum;
import com.fsgame.chesscore.utils.IntlChessUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @Author: root
 * @Date: 2023/12/4 15:47
 * @Description:
 */
public class IntlChessBoard implements Board {

    private static final Logger logger = LoggerFactory.getLogger(IntlChessBoard.class);

    private BaseEnum roleEnum;

    private final Piece[][] board = new Piece[8][8];

    private final Deque<WalkingRecords> walkingRecordsStack = new LinkedList<>();

    private final Map<String, PieceMove> pieceMoveBehavior = new HashMap<>();

    public IntlChessBoard() {
        this(IntlRoleEnum.W);
    }

    public IntlChessBoard(BaseEnum roleEnum) {
        this.roleEnum = roleEnum;
        initPieceBehavior();
        initPiece(IntlChessUtil.getMySelfPieceInitCoord(roleEnum), roleEnum);
        initPiece(IntlChessUtil.getOpponentPieceInitCoord(roleEnum), IntlRoleEnum.W.equals(roleEnum) ? IntlRoleEnum.B : IntlRoleEnum.W);
    }

    private void initPiece(Map<BaseEnum, int[][]> coordsMap, BaseEnum roleEnum) {
        for (Map.Entry<BaseEnum, int[][]> entry : coordsMap.entrySet()) {
            BaseEnum pieceEnum = entry.getKey();
            initPiece(pieceEnum, coordsMap.get(pieceEnum), roleEnum);
        }
    }

    private void initPiece(BaseEnum pieceEnum, int[][] coords, BaseEnum roleEnum) {
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
            logger.debug(e.getMessage());
        }
    }

    @Override
    public BaseEnum<String> getRoleEnum() {
        return roleEnum;
    }

    @Override
    public Piece getPiece(int[] coord) {
        return validRange(coord) ? getPiece(coord[0], coord[1]) : null;
    }

    @Override
    public Piece getPiece(int x, int y) {
        return board[x][y];
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

    private boolean allowMove(int[] source) {
        // 黑白先后顺序判定，取决于历史记录（这段先注释，测试完在放开）
        Piece piece = getPiece(source);
        if (piece == null) {
            return false;
        }
        if (getRecords().isEmpty() && IntlRoleEnum.B.equals(piece.getRole())) {
            return false;
        }
        if (!getRecords().isEmpty()) {
            WalkingRecords walkingRecords = getRecords().getLast();
            List<WalkingRecords.Record> records = walkingRecords.getRecords();
            Piece lastPiece = records.get(0).piece();
            return !piece.getRole().equals(lastPiece.getRole());
        }
        return true;
    }

    @Override
    public boolean move(int[] source, int[] target) {
        Piece piece = getPiece(source);
        if (piece == null || !allowMove(source)) {
            return false;
        }

        WalkingRecords walkingRecords = piece.move(target);
        if (walkingRecords == null) {
            return false;
        }
        piece.updateCoord(target);
        addRecords(walkingRecords);
        return true;
    }

    @Override
    public int rows() {
        return board.length;
    }

    @Override
    public int columns() {
        return rows() != 0 ? board[0].length : 0;
    }

    @Override
    public void swap(int[] source, int[] target) {
        Piece piece = getPiece(source);
        updateBoard(source, getPiece(target));
        updateBoard(target, piece);
    }

    @Override
    public boolean unimpededRoute(int[] source, int[] target) {
        // x,y轴移动的方向(-1, 0, 1)
        int direX = Integer.compare(target[0] - source[0], 0);
        int direY = Integer.compare(target[1] - source[1], 0);

        int tempX = source[0];
        int tempY = source[1];
        while (validRange(tempX, tempY)) {
            tempX += direX;
            tempY += direY;
            if (tempX == target[0] && tempY == target[1]) {
                break;
            }
            if (getPiece(tempX, tempY) != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validRange(int[] coord) {
        return validRange(coord[0], coord[1]);
    }

    @Override
    public boolean validRange(int x, int y) {
        return x >= 0 && y >= 0 && x < rows() && y < columns();
    }


    private void initPieceBehavior() {
        for (BaseEnum behaviorEnum : IntlBehaviorEnum.values()) {
            try {

                Class<?> clazz = Class.forName(IntlChessUtil.MOVE_BEHAVIOR_PATH + behaviorEnum.getCode());
                if (clazz == null) {
                    continue;
                }

                PieceMove pieceMove = (PieceMove) clazz.getDeclaredConstructor().newInstance();
                pieceMoveBehavior.put(behaviorEnum.getCode().toString(), pieceMove);

            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                    InvocationTargetException e) {
                logger.info("不存在行为实体类：{} {}", behaviorEnum.getCode(), behaviorEnum.getDesc());
            }
        }
    }

    public Map<String, PieceMove> getPieceMoveBehavior() {
        return pieceMoveBehavior;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!getRecords().isEmpty()) {
            sb.append(getRecords().getLast().getRecords()).append("\n");
        }

        for (Piece[] pieces : getBoard()) {
            for (Piece piece : pieces) {
                sb.append(piece != null ? piece.getRole().getName() + "." + piece.getType().getName() : "---")
                        .append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
