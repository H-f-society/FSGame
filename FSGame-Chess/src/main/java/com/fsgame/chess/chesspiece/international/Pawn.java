package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 15:12
 * @Description:
 */
public class Pawn extends AbstractPiece {

    public Pawn(Board board, int[] coord) {
        super(board, coord);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.P;
    }

    @Override
    public boolean allowMove(int[] coord) {
        int absX = Math.abs(this.coord[0] - coord[0]);
        int absY = Math.abs(this.coord[1] - coord[1]);
        // 左右只允许移动1格, 初始状态上下最多移动2格，之后上下最多移动1格
        if (absY > 1 || (stepCount == 0 && absX > 2) || (stepCount != 0 && absX > 1)) {
            return false;
        }
        if (absX > 1 && absY > 0) {
            return false;
        }
        // 斜方一格没有其它棋子，不允许移动（斜着吃子）
        if (absX == 1 && absY == 1 && board.getBoard()[coord[0]][coord[1]] == null) {
            return false;
        }
        // 移动方向（上下）
        int dire = -1;
        // 我方棋子，只许向上移动
        if (isMyPiece() && coord[0] >= this.coord[0]) {
            return false;
        }
        // 敌方棋子，只许向下移动
        if (!isMyPiece() && coord[0] <= this.coord[0]) {
            dire = 1;
            return false;
        }
        // 前面一格有其它棋子，不能移动
        if (board.getBoard()[this.coord[0] + dire][this.coord[1]] != null) {
            return false;
        }
        return true;
    }

    @Override
    public BaseEnum move(int[] coord) {
        if (!super.allowMove(coord) || !this.allowMove(coord)) {
            return IntlBehaviorEnum.NOT_MOVE;
        }
        board.updateBoard(this.coord[0], this.coord[1], null);
        board.updateBoard(coord[0], coord[1], this);
        stepCount++;
        return IntlBehaviorEnum.MOVE;
    }
}
