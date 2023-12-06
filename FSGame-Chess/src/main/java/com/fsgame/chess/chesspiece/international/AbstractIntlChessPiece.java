package com.fsgame.chess.chesspiece.international;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.chesspiece.AbstractPiece;
import com.fsgame.chess.enums.BaseEnum;
import com.fsgame.chess.enums.DirectionEnum;

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

}
