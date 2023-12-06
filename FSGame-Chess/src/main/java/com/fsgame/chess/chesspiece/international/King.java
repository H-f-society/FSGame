package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.utils.DirectionUtil;

/**
 * @Author: root
 * @Date: 2023/12/4 15:01
 * @Description:
 */
public class King extends AbstractIntlChessPiece {

    public King(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    public void initAllowDirection() {
        allowDirectionSet.clear();
        DirectionUtil.allDirection(allowDirectionSet);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.K;
    }

    /**
     * 王车易位
     * @return
     */
    private boolean castling() {
        return false;
    }
}
