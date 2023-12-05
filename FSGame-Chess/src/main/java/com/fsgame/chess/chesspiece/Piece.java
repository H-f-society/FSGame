package com.fsgame.chess.chesspiece;

import com.fsgame.chess.enums.specific.PieceEnum;
import com.fsgame.chess.enums.specific.RoleEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 14:51
 * @Description:
 */
public interface Piece {

    PieceEnum getType();

    RoleEnum getRole();

    int StepCount();

    String getColor();

    int[] initCoord();

    boolean allowMove(int[] coord);
}
