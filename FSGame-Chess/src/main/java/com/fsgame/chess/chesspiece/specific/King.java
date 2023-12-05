package com.fsgame.chess.chesspiece.specific;

import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.specific.PieceEnum;
import com.fsgame.chess.enums.specific.RoleEnum;

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
    public String getColor() {
        return null;
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
