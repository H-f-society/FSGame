package com.fsgame.chess.chesspiece;

import com.fsgame.chess.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 14:51
 * @Description:
 */
public interface Piece {

    BaseEnum getType();

    void setRole(BaseEnum roleEnum);

    BaseEnum getRole();

    int getStepCount();

    boolean allowMove(int[] coord);

    BaseEnum move(int[] coord);
}
