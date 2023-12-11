package com.fsgame.chess.rule.chesspiece;

import com.fsgame.chess.rule.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 14:51
 * @Description:
 */
public interface Piece {

    void updateCoord(int[] coord);

    void updateCoord(int x, int y);

    BaseEnum getType();

    void setRole(BaseEnum roleEnum);

    BaseEnum getRole();

    int getStepCount();

    boolean allowMove(int[] coord);

    BaseEnum move(int[] coord);

    int stepNum(int[] coord);

    int stepNum(int[] source, int[] target);
}
