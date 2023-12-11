package com.fsgame.chess.utils;

import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.enums.international.IntlRoleEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: root
 * @Date: 2023/12/5 10:27
 * @Description:
 */
public class IntlChessUtil {

    public static final String PACKER_PATH = "com.fsgame.chess.chesspiece.international.";

    public static final int[][] WHITE_K = new int[][] {{7, 4}};
    public static final int[][] WHITE_Q = new int[][] {{7, 3}};
    public static final int[][] BLACK_Q = new int[][] {{0, 3}};
    public static final int[][] BLACK_K = new int[][] {{0, 4}};

    public static final int[][] OPPONENT_B = new int[][] {{0, 2}, {0, 5}};
    public static final int[][] OPPONENT_N = new int[][] {{0, 1}, {0, 6}};
    public static final int[][] OPPONENT_R = new int[][] {{0, 0}, {0, 7}};
    public static final int[][] OPPONENT_P = new int[][] {{1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}};

    public static final int[][] MYSELF_B = new int[][] {{7, 2}, {7, 5}};
    public static final int[][] MYSELF_N = new int[][] {{7, 1}, {7, 6}};
    public static final int[][] MYSELF_R = new int[][] {{7, 0}, {7, 7}};
    public static final int[][] MYSELF_P = new int[][] {{6, 0}, {6, 1}, {6, 2}, {6, 3}, {6, 4}, {6, 5}, {6, 6}, {6, 7}};

    public static Map<IntlPieceEnum, int[][]> getMySelfPieceInitCoord(BaseEnum roleEnum) {
        int[][] kingCoord = IntlRoleEnum.W.equals(roleEnum) ? WHITE_K : WHITE_Q;
        int[][] queenCoord = IntlRoleEnum.W.equals(roleEnum) ? WHITE_Q : WHITE_K;
        return getIntlPieceEnumMap(kingCoord, queenCoord, MYSELF_B, MYSELF_N, MYSELF_R, MYSELF_P);
    }

    public static Map<IntlPieceEnum, int[][]> getOpponentPieceInitCoord(BaseEnum roleEnum) {
        int[][] kingCoord = IntlRoleEnum.B.equals(roleEnum) ? BLACK_Q : BLACK_K;
        int[][] queenCoord = IntlRoleEnum.B.equals(roleEnum) ? BLACK_K : BLACK_Q;
        return getIntlPieceEnumMap(kingCoord, queenCoord, OPPONENT_B, OPPONENT_N, OPPONENT_R, OPPONENT_P);
    }

    private static Map<IntlPieceEnum, int[][]> getIntlPieceEnumMap(
              int[][] king
            , int[][] queen
            , int[][] bishop
            , int[][] knight
            , int[][] rook
            , int[][] pawn) {
        Map<IntlPieceEnum, int[][]> coordsMap = new HashMap<>();
        coordsMap.put(IntlPieceEnum.K, king);
        coordsMap.put(IntlPieceEnum.Q, queen);
        coordsMap.put(IntlPieceEnum.B, bishop);
        coordsMap.put(IntlPieceEnum.N, knight);
        coordsMap.put(IntlPieceEnum.R, rook);
        coordsMap.put(IntlPieceEnum.P, pawn);
        return coordsMap;
    }
}
