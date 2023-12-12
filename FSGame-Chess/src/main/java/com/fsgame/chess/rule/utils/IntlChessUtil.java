package com.fsgame.chess.rule.utils;

import com.fsgame.chess.rule.enums.BaseEnum;
import com.fsgame.chess.rule.enums.international.IntlPieceEnum;
import com.fsgame.chess.rule.enums.international.IntlRoleEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: root
 * @Date: 2023/12/5 10:27
 * @Description:
 */
public class IntlChessUtil {

    public static final String PACKER_PATH = "com.fsgame.chess.rule.chesspiece.international.";

    public static final int[][] WHITE_K = {{7, 4}};
    public static final int[][] WHITE_Q = {{7, 3}};
    public static final int[][] BLACK_Q = {{0, 3}};
    public static final int[][] BLACK_K = {{0, 4}};

    public static final int[][] OPPONENT_B = {{0, 2}, {0, 5}};
    public static final int[][] OPPONENT_N = {{0, 1}, {0, 6}};
    public static final int[][] OPPONENT_R = {{0, 0}, {0, 7}};
    public static final int[][] OPPONENT_P = {{1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}};

    public static final int[][] MYSELF_B = {{7, 2}, {7, 5}};
    public static final int[][] MYSELF_N = {{7, 1}, {7, 6}};
    public static final int[][] MYSELF_R = {{7, 0}, {7, 7}};
    public static final int[][] MYSELF_P = {{6, 0}, {6, 1}, {6, 2}, {6, 3}, {6, 4}, {6, 5}, {6, 6}, {6, 7}};

    public static Map<BaseEnum, int[][]> getMySelfPieceInitCoord(BaseEnum roleEnum) {
        int[][] kingCoord = IntlRoleEnum.W.equals(roleEnum) ? WHITE_K : WHITE_Q;
        int[][] queenCoord = IntlRoleEnum.W.equals(roleEnum) ? WHITE_Q : WHITE_K;
        return getIntlPieceEnumMap(kingCoord, queenCoord, MYSELF_B, MYSELF_N, MYSELF_R, MYSELF_P);
    }

    public static Map<BaseEnum, int[][]> getOpponentPieceInitCoord(BaseEnum roleEnum) {
        int[][] kingCoord = IntlRoleEnum.B.equals(roleEnum) ? BLACK_Q : BLACK_K;
        int[][] queenCoord = IntlRoleEnum.B.equals(roleEnum) ? BLACK_K : BLACK_Q;
        return getIntlPieceEnumMap(kingCoord, queenCoord, OPPONENT_B, OPPONENT_N, OPPONENT_R, OPPONENT_P);
    }

    private static Map<BaseEnum, int[][]> getIntlPieceEnumMap(
              int[][] king
            , int[][] queen
            , int[][] bishop
            , int[][] knight
            , int[][] rook
            , int[][] pawn) {
        Map<BaseEnum, int[][]> coordsMap = new HashMap<>();
        coordsMap.put(IntlPieceEnum.K, king);
        coordsMap.put(IntlPieceEnum.Q, queen);
        coordsMap.put(IntlPieceEnum.B, bishop);
        coordsMap.put(IntlPieceEnum.N, knight);
        coordsMap.put(IntlPieceEnum.R, rook);
        coordsMap.put(IntlPieceEnum.P, pawn);
        return coordsMap;
    }
}
