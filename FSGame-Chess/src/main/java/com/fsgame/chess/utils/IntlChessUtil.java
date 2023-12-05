package com.fsgame.chess.utils;

import com.fsgame.chess.enums.international.IntlPieceEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: root
 * @Date: 2023/12/5 10:27
 * @Description:
 */
public class IntlChessUtil {

    public static final int[][] W_K = new int[][] {{0, 4}};
    public static final int[][] W_Q = new int[][] {{0, 3}};
    public static final int[][] W_B = new int[][] {{0, 2}, {0, 5}};
    public static final int[][] W_N = new int[][] {{0, 1}, {0, 6}};
    public static final int[][] W_R = new int[][] {{0, 0}, {0, 7}};
    public static final int[][] W_P = new int[][] {{1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}};

    public static final int[][] B_K = new int[][] {{7, 4}};
    public static final int[][] B_Q = new int[][] {{7, 3}};
    public static final int[][] B_B = new int[][] {{7, 2}, {7, 5}};
    public static final int[][] B_N = new int[][] {{7, 1}, {7, 6}};
    public static final int[][] B_R = new int[][] {{7, 0}, {7, 7}};
    public static final int[][] B_P = new int[][] {{6, 0}, {6, 1}, {6, 2}, {6, 3}, {6, 4}, {6, 5}, {6, 6}, {6, 7}};

    public static Map<IntlPieceEnum, int[][]> getWhitePieceInitCoord() {
        return getIntlPieceEnumMap(W_K, W_Q, W_B, W_N, W_R, W_P);
    }

    public static Map<IntlPieceEnum, int[][]> getBlackPieceInitCoord() {
        return getIntlPieceEnumMap(B_K, B_Q, B_B, B_N, B_R, B_P);
    }

    private static Map<IntlPieceEnum, int[][]> getIntlPieceEnumMap(int[][] bK, int[][] bQ, int[][] bB, int[][] bN, int[][] bR, int[][] bP) {
        Map<IntlPieceEnum, int[][]> coordsMap = new HashMap<>();
        coordsMap.put(IntlPieceEnum.K, bK);
        coordsMap.put(IntlPieceEnum.Q, bQ);
        coordsMap.put(IntlPieceEnum.B, bB);
        coordsMap.put(IntlPieceEnum.N, bN);
        coordsMap.put(IntlPieceEnum.R, bR);
        coordsMap.put(IntlPieceEnum.P, bP);
        return coordsMap;
    }
}
