package com.fsgame.chess.rule.chesspiece.international.movespecific;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chesspiece.Piece;
import com.fsgame.chess.rule.chesspiece.international.Queen;
import com.fsgame.chess.rule.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.rule.enums.international.IntlPieceEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 21:00
 * @Description:
 */
public class Promotion extends AbstractIntlPieceMove {

    private static final IntlPieceEnum PIECE = IntlPieceEnum.P;

    // 我方底线X轴索引值
    private static final int MYSELF_SIDE_LINE_X_INDEX = 7;

    // 对公底线X轴索引值
    private static final int OPPONENT_SIDE_LINE_X_INDEX = 0;

    public Promotion() {
        super(IntlBehaviorEnum.PROMOTION);
    }

    @Override
    public boolean move(Board board, int[] source, int[] target) {
        Piece sourcePiece = board.getPiece(source);
        Piece targetPiece = board.getPiece(target);
        // 兵升前提条件: 起始格子有小兵、目标格子没有其它棋子
        if (sourcePiece == null || (targetPiece != null && !PIECE.equals(sourcePiece.getType()))) {
            return false;
        }

        // 当前移动小兵的目标底线
        int targetSideLine = board.getRoleEnum().equals(sourcePiece.getRole()) ? OPPONENT_SIDE_LINE_X_INDEX : MYSELF_SIDE_LINE_X_INDEX;

        // 默认只是移动过去，不升变
        if (target[0] == targetSideLine) {
            board.swap(source, target);
            board.updateBoard(source, null);
            // setMoveBehavior(targetPiece != null ? IntlBehaviorEnum.CAPTURE : IntlBehaviorEnum.MOVE);

            // 测试升变用
            Piece piece = new Queen(board, target);
            piece.setRole(sourcePiece.getRole());
            board.updateBoard(target, piece);

            return true;
        }
        return false;
    }
}
