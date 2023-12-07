package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.enums.DirectionEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 15:12
 * @Description:
 */
public class Pawn extends AbstractIntlChessPiece {

    public Pawn(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    public void initAllowDirection() {
        allowDirectionSet.clear();
        allowDirectionSet.add(isMyPiece() ? DirectionEnum.UP : DirectionEnum.DOWN);
        allowDirectionSet.add(isMyPiece() ? DirectionEnum.LEFT_UP : DirectionEnum.LEFT_DOWN);
        allowDirectionSet.add(isMyPiece() ? DirectionEnum.RIGHT_UP : DirectionEnum.RIGHT_DOWN);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.P;
    }

    @Override
    public boolean allowMove(int[] coord) {
        if ((stepCount == 0 && stepNum(coord) > 2) || (stepCount > 0 && stepNum(coord) > 1)) {
            return false;
        }
        super.allowMove(coord);
        return true;
    }
}
