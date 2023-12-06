package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.DirectionEnum;
import com.fsgame.chess.enums.international.IntlBehaviorEnum;
import com.fsgame.chess.utils.DirectionUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: root
 * @Date: 2023/12/6 21:44
 * @Description:
 */
public abstract class AbstractIntlChessPiece extends AbstractPiece {

    protected int allowMaxStep;

    protected Set<DirectionEnum> allowDirectionSet = new HashSet<>();

    public AbstractIntlChessPiece(Board board, int[] coord) {
        super(board, coord);
    }

    protected abstract void initAllowDirection();

    @Override
    public void setRole(BaseEnum roleEnum) {
        super.setRole(roleEnum);
        initAllowDirection();
    }

    @Override
    public boolean allowMove(int[] coord) {
        DirectionEnum dire = DirectionUtil.calcDirection(this.coord, coord);
        // 如果目标点在可允许的移动方向上，并且路途上无障碍，允许移动
        if (allowDirectionSet.contains(dire) && unimpededRoute(coord)) {
            return true;
        }
        return false;
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

    /**
     * 无障碍的路线
     * @return true or false
     */
    protected boolean unimpededRoute(int[] coord) {
        return unimpededRoute(coord[0], coord[1]);
    }

    protected boolean unimpededRoute(int x, int y) {
        // x,y轴移动的方向(-1, 0, 1)
        int direX = Integer.compare(x - this.coord[0], 0);
        int direY = Integer.compare(y - this.coord[1], 0);

        int tempX = this.coord[0];
        int tempY = this.coord[1];
        while(validRange(tempX, tempY) && tempX != x && tempY != y) {
            tempX += direX;
            tempY += direY;
            if (board.getBoard()[tempX][tempY] != null) {
                return false;
            }
        }
        return true;
    }

}
