package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.international.PieceEnum;
import com.fsgame.chess.enums.international.RoleEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 15:01
 * @Description:
 */
public class King implements Piece {
    @Override
    public PieceEnum getType() {
        return PieceEnum.K;
    }

    @Override
    public RoleEnum getRole() {
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
