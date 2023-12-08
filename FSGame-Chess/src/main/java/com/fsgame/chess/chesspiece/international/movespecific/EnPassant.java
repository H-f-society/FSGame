package com.fsgame.chess.chesspiece.international.movespecific;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chessboard.WalkingRecords;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;

/**
 * @Author: root
 * @Date: 2023/12/7 21:01
 * @Description:
 */
public class EnPassant extends Capture {

    private static final IntlPieceEnum PIECE = IntlPieceEnum.P;

    public EnPassant() {
        super(IntlBehaviorEnum.EN_PASSANT);
    }

    @Override
    public boolean move(Board board, int[] source, int[] target) {
        int absX = Math.abs(target[0] - source[0]);
        int absY = Math.abs(target[1] - source[1]);

        // 小兵斜吃必须斜走一格
        if (absX != 1 || absY != 1) {
            return false;
        }

        Piece sourcePiece = board.getPiece(source);
        Piece targetPiece = board.getPiece(target);

        if (sourcePiece == null || !PIECE.equals(sourcePiece.getType())) {
            return false;
        }
        // 俩棋子不能为同一色
        if (targetPiece != null && sourcePiece.getRole().equals(targetPiece.getRole())) {
            return false;
        }
        // 小兵的常规吃法，斜吃
        if (targetPiece != null) {
            board.swap(source, target);
            board.updateBoard(source, null);
            setMoveBehavior(IntlBehaviorEnum.CAPTURE);
            return true;
        }
        // target那一侧方向，在source旁边的棋子，是否为小兵
        Piece beside = board.getPiece(source[0], target[1]);
        // 上一次移动记录的棋子，是不是小兵
        WalkingRecords walkingRecords = board.getRecords().getLast();
        Piece lastPiece = walkingRecords.getPiece();

        // 吃过路兵，旁侧棋子和上一条记录的棋子大都是同一个小兵，并且上一次移动了2次，允许吃
        if (lastPiece.equals(beside) && PIECE.equals(lastPiece.getType())) {
            int stepNum = lastPiece.stepNum(walkingRecords.getSource(), walkingRecords.getTarget());
            if (stepNum == 2) {
                board.swap(source, target);
                board.updateBoard(source[0], target[1], null);
                return true;
            }

        }

        return false;
    }
}
