package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.DirectionEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.enums.international.IntlPieceEnum;
import com.fsgame.chess.utils.DirectionUtil;

/**
 * @Author: root
 * @Date: 2023/12/4 15:12
 * @Description:
 */
public class Pawn extends AbstractPiece {

    public Pawn(Board board, int[] coord) {
        super(board, coord);
        initAllowDirection();
    }

    @Override
    public void initAllowDirection() {
        allowDirectionSet.add(DirectionEnum.UP);
        allowDirectionSet.add(DirectionEnum.LEFT_UP);
        allowDirectionSet.add(DirectionEnum.RIGHT_UP);
    }

    @Override
    public IntlPieceEnum getType() {
        return IntlPieceEnum.P;
    }

    @Override
    public boolean allowMove(int[] coord) {
        DirectionEnum dire = DirectionUtil.calcDirection(this.coord, coord);
        return allowDirectionSet.contains(dire);
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
