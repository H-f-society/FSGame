package com.fsgame.chess.board;

import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.international.BehaviorEnum;

/**
 * @Author: root
 * @Date: 2023/12/5 9:04
 * @Description:
 */
public class Behavior {

    private final Piece source;

    private final Piece target;

    private final BehaviorEnum behaviorEnum;

    public Behavior(Piece source, Piece target, BehaviorEnum behaviorEnum) {
        this.source = source;
        this.target = target;
        this.behaviorEnum = behaviorEnum;
    }

    public Piece getSource() {
        return source;
    }

    public Piece getTarget() {
        return target;
    }

    public BehaviorEnum getBehaviorEnum() {
        return behaviorEnum;
    }

}
