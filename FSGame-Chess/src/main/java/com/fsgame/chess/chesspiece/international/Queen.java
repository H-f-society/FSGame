package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.enums.international.IntlRoleEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 15:00
 * @Description:
 */
public class Queen implements Piece {
    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.Q;
    }

    @Override
    public IntlRoleEnum getRole() {
        return null;
    }

    @Override
    public int StepCount() {
        return 0;
    }

    @Override
    public int[] initCoord() {
        return new int[0];
    }

    @Override
    public boolean allowMove(int[] coord) {
        return false;
    }
}
