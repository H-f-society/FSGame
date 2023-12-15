package com.fsgame.chesscore.chesspiece.international;

import com.fsgame.chesscore.chessboard.Board;
import com.fsgame.chesscore.enums.international.IntlPieceEnum;
import com.fsgame.chesscore.utils.DirectionUtil;

/**
 * @Author: root
 * @Date: 2023/12/4 15:11
 * @Description:
 */
public class Bishop extends AbstractIntlChessPiece {

    public Bishop(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    protected void initAllowDirection() {
        allowDirectionSet.clear();
        DirectionUtil.diagonalLineDire(allowDirectionSet);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.B;
    }
}
