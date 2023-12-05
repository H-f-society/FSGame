package com.fsgame.chess.chesspiece;

import com.fsgame.chess.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 14:51
 * @Description:
 */
public interface Piece {

    BaseEnum getType();

    BaseEnum getRole();

    int StepCount();

    int[] initCoord();

    boolean allowMove(int[] coord);

    boolean move(int[] coord);
}
