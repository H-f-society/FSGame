package com.fsgame.chess.board;

import com.fsgame.chess.chesspiece.Piece;

/**
 * @Author: root
 * @Date: 2023/12/4 16:55
 * @Description:
 */
public class WalkingRecords {

    private final int[] source;

    private final int[] target;

    private final Piece piece;

    private final Behavior behavior;

    public WalkingRecords(int[] source, int[] target, Piece piece, Behavior behavior) {
        this.source = source;
        this.target = target;
        this.piece = piece;
        this.behavior = behavior;
    }

    public int[] getSource() {
        return source;
    }

    public int[] getTarget() {
        return target;
    }

    public Piece getPiece() {
        return piece;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public static class Builder {
        private int[] source;

        private int[] target;

        private Piece piece;

        private Behavior behavior;

        public Builder source(int[] source) {
            this.source = source;
            return this;
        }

        public Builder target(int[] target) {
            this.target = target;
            return this;
        }

        public Builder piece(Piece piece) {
            this.piece = piece;
            return this;
        }

        public Builder behavior(Behavior behavior) {
            this.behavior = behavior;
            return this;
        }

        public WalkingRecords build() {
            return new WalkingRecords(source, target, piece, behavior);
        }
    }
}
