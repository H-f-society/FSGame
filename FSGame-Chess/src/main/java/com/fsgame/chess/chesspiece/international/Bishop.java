package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.DirectionEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.utils.DirectionUtil;

/**
 * @Author: root
 * @Date: 2023/12/4 15:11
 * @Description:
 */
public class Bishop extends AbstractPiece {

    public Bishop(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    public void initAllowDirection() {
        allowDirectionSet.clear();
        DirectionUtil.diagonalLineDire(allowDirectionSet);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.B;
    }

    @Override
    public boolean allowMove(int[] coord) {
        return false;
    }

    @Override
    public BaseEnum move(int[] coord) {
        return null;
    }
}
