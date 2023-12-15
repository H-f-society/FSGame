package com.fsgame.chesscore.chesspiece.international.movespecific;

import com.fsgame.chesscore.chessboard.Board;
import com.fsgame.chesscore.chessboard.WalkingRecords;
import com.fsgame.chesscore.chessboard.WalkingRecordsImpl;
import com.fsgame.chesscore.chesspiece.Piece;
import com.fsgame.chesscore.enums.international.IntlBehaviorEnum;
import com.fsgame.chesscore.enums.international.IntlPieceEnum;
import com.fsgame.chesscore.enums.international.IntlRoleEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 20:57
 * @Description:
 */
public class Castling extends AbstractIntlPieceMove {

    private static final IntlPieceEnum KING = IntlPieceEnum.K;
    private static final IntlPieceEnum ROOK = IntlPieceEnum.R;

    @Override
    public WalkingRecords move(Board board, int[] source, int[] target) {
        int x = source[0];
        int dire = target[1] - source[1] > 0 ? 1 : -1;
        int[] rookSource = dire == -1 ? new int[]{x, 0} : new int[]{x, 7};

        Piece king = board.getPiece(source);
        Piece rook = board.getPiece(rookSource);

        // 基本要求1：起始点为King，目标点为Rook，且途中无障碍
        if (king == null || rook == null) {
            return null;
        }
        if (!KING.equals(king.getType()) || !ROOK.equals(rook.getType()) || !board.unimpededRoute(source, rookSource)) {
            return null;
        }
        // 基本要求2: King和Rook均为移动过
        if (king.getStepCount() != 0 || rook.getStepCount() != 0) {
            return null;
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
            return null;
        }
        WalkingRecords.Record kingRecord = new WalkingRecords.RecordImpl(king, source.clone(), kingCoord.clone());
        WalkingRecords.Record rookRecord = new WalkingRecords.RecordImpl(rook, rookSource.clone(), rookCoord.clone());
        board.swap(source, kingCoord);
        board.swap(rookSource, rookCoord);
        rook.updateCoord(rookCoord);
        return new WalkingRecordsImpl.Builder()
                .record(kingRecord)
                .record(rookRecord)
                .behavior(IntlBehaviorEnum.CASTLING)
                .build();
    }

}
