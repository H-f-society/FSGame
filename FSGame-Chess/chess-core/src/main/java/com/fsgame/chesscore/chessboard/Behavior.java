package com.fsgame.chesscore.chessboard;

import com.fsgame.chesscore.chesspiece.Piece;
import com.fsgame.chesscore.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/5 9:04
 * @Description:
 */
public class Behavior {

    private final Piece source;

    private final Piece target;

    private final BaseEnum behaviorEnum;

    public Behavior(Piece source, Piece target, BaseEnum behaviorEnum) {
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

    public BaseEnum getBehaviorEnum() {
        return behaviorEnum;
    }

}
