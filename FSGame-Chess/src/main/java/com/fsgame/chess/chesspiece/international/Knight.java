package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chesspiece.international.movespecific.Capture;
import com.fsgame.chess.chesspiece.international.movespecific.Castling;
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
    protected void initAllowDirection() {
        allowDirectionSet.clear();
        allowDirectionSet.add(DirectionEnum.SPECIFIED);
    }

    @Override
    protected void initAllowMoveBehavior() {
        super.initAllowMoveBehavior();
        allowMoveBehaviorList.add(new Capture());
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.N;
    }

    @Override
    public boolean allowMove(int[] coord) {
        int x = Math.abs(coord[0] - this.coord[0]);
        int y = Math.abs(coord[1] - this.coord[1]);
        return (x == 1 && y == 2) || (x == 2 && y == 1);
    }
}
