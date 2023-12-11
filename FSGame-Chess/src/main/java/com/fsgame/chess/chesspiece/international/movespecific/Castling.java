package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.enums.international.IntlRoleEnum;
import com.fsgame.chess.utils.IntlChessUtil;

/**
 * @Author: root
 * @Date: 2023/12/7 20:57
 * @Description:
 */
public class Castling extends AbstractIntlPieceMove {

    private static final IntlPieceEnum KING = IntlPieceEnum.K;
    private static final IntlPieceEnum ROOK = IntlPieceEnum.R;

    public Castling() {
        super(IntlBehaviorEnum.CASTLING);
    }

    @Override
    public boolean move(Board board, int[] source, int[] target) {
        int x = source[0];
        int dire = target[1] - source[1] > 0 ? 1 : -1;
        int[] rookSource = dire == -1 ? new int[]{x, 0} : new int[]{x, 7};

        Piece king = board.getPiece(source);
        Piece rook = board.getPiece(rookSource);

        // 基本要求1：起始点为King，目标点为Rook，且途中无障碍
        setMoveBehavior(IntlBehaviorEnum.NOT_MOVE);
        if (king == null || rook == null) {
            return false;
        }
        if (!KING.equals(king.getType()) || !ROOK.equals(rook.getType()) || !board.unimpededRoute(source, target)) {
            return false;
        }
        // 基本要求2: King和Rook均为移动过
        if (king.getStepCount() != 0 || rook.getStepCount() != 0) {
            return false;
        }

        int[] kingCoord = new int[0];
        int[] rookCoord = new int[0];

        if (IntlRoleEnum.W.equals(board.getRoleEnum())) {
            kingCoord = dire == -1 ? new int[]{x, 2} : new int[]{x, 6};
            rookCoord = dire == -1 ? new int[]{x, 3} : new int[]{x, 5};
        }

        if (IntlRoleEnum.B.equals(board.getRoleEnum())) {
            kingCoord = dire == -1 ? new int[]{x, 1} : new int[]{x, 5};
            rookCoord = dire == -1 ? new int[]{x, 2} : new int[]{x, 4};
        }

        if (kingCoord.length == 0) {
            return false;
        }
        board.swap(source, kingCoord);
        board.swap(rookSource, rookCoord);
        setMoveBehavior(IntlBehaviorEnum.CASTLING);
        return true;
    }

}
