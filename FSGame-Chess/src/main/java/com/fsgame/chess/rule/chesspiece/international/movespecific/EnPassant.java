package com.fsgame.chess.rule.chesspiece.international.movespecific;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chessboard.WalkingRecords;
import com.fsgame.chess.rule.chessboard.WalkingRecordsImpl;
import com.fsgame.chess.rule.chesspiece.Piece;
import com.fsgame.chess.rule.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.rule.enums.international.IntlPieceEnum;

import java.util.List;

/**
 * @Author: root
 * @Date: 2023/12/7 21:01
 * @Description:
 */
public class EnPassant extends Capture {

    private static final IntlPieceEnum PIECE = IntlPieceEnum.P;

    @Override
    public WalkingRecords move(Board board, int[] source, int[] target) {
        int absX = Math.abs(target[0] - source[0]);
        int absY = Math.abs(target[1] - source[1]);

        // 小兵斜吃必须斜走一格
        if (absX != 1 || absY != 1) {
            return null;
        }

        Piece sourcePiece = board.getPiece(source);
        Piece targetPiece = board.getPiece(target);

        if (sourcePiece == null || !PIECE.equals(sourcePiece.getType())) {
            return null;
        }
        // 俩棋子不能为同一色
        if (targetPiece != null && sourcePiece.getRole().equals(targetPiece.getRole())) {
            return null;
        }
        // 小兵的常规吃法，斜吃
        if (targetPiece != null) {
            WalkingRecords.Record pawnRecord = new WalkingRecords.RecordImpl(sourcePiece, source.clone(), target.clone());
            board.swap(source, target);
            board.updateBoard(source, null);
            return new WalkingRecordsImpl.Builder()
                    .record(pawnRecord)
                    .behavior(IntlBehaviorEnum.CAPTURE)
                    .build();
        }
        // target那一侧方向，在source旁边的棋子，是否为小兵
        Piece beside = board.getPiece(source[0], target[1]);
        // 上一次移动记录的棋子，是不是小兵

        WalkingRecords walkingRecords = board.getRecords().getLast();
        List<WalkingRecords.Record> records = walkingRecords.getRecords();
        Piece lastPiece = records.get(0).piece();

        // 吃过路兵，旁侧棋子和上一条记录的棋子大都是同一个小兵，并且上一次移动了2次，允许吃
        if (lastPiece.equals(beside) && PIECE.equals(lastPiece.getType())) {
            int stepNum = lastPiece.stepNum(records.get(0).source(), records.get(0).target());
            if (stepNum == 2) {
                WalkingRecords.Record pawnRecord = new WalkingRecords.RecordImpl(sourcePiece, source.clone(), target.clone());
                WalkingRecords.Record besideRecord = new WalkingRecords.RecordImpl(beside, new int[]{source[0], target[1]}, null);
                board.swap(source, target);
                board.updateBoard(source[0], target[1], null);

                return new WalkingRecordsImpl.Builder()
                        .record(pawnRecord)
                        .record(besideRecord)
                        .behavior(IntlBehaviorEnum.EN_PASSANT)
                        .build();
            }

        }

        return null;
    }
}
