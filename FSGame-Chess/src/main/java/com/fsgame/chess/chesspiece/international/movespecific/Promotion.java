package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 21:00
 * @Description:
 */
public class Promotion extends AbstractIntlPieceMove {

    private static final IntlBehaviorEnum MOVE_BEHAVIOR = IntlBehaviorEnum.PROMOTION;

    // 我方底线X轴索引值
    private static final int MYSELF_SIDE_LINE_X_INDEX = 7;

    // 对公底线X轴索引值
    private static final int OPPONENT_SIDE_LINE_X_INDEX = 0;
    @Override
    public IntlBehaviorEnum getType() {
        return MOVE_BEHAVIOR;
    }

    @Override
    public boolean move(Board board, int[] source, int[] target) {
        Piece sourcePiece = board.getPiece(source);
        Piece targetPiece = board.getPiece(target);
        // 兵升前提条件: 起始格子有小兵、目标格子没有其它棋子
        if (sourcePiece == null || targetPiece != null || !IntlPieceEnum.P.equals(sourcePiece.getType())) {
            return false;
        }

        // 当前移动小兵的目标底线
        int targetSideLine = board.getRoleEnum().equals(sourcePiece.getRole()) ? OPPONENT_SIDE_LINE_X_INDEX : MYSELF_SIDE_LINE_X_INDEX;

        return target[0] == targetSideLine;
    }
}
