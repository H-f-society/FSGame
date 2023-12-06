package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.enums.DirectionEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 15:12
 * @Description:
 */
public class Knight extends AbstractIntlChessPiece {

    public Knight(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    public void initAllowDirection() {
        allowDirectionSet.clear();
        allowDirectionSet.add(DirectionEnum.SPECIFIED);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.N;
    }
}
