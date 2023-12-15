package com.fsgame.chess.rule.chessboard;

import com.fsgame.chess.rule.chesspiece.Piece;
import com.fsgame.chess.rule.enums.BaseEnum;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: root
 * @Date: 2023/12/15 14:37
 * @Description:
 */
public interface WalkingRecords {

    BaseEnum getBehavior();

    List<Record> getRecords();

    interface Record {

        Piece piece();

        int[] source();

        int[] target();
    }

    class RecordImpl implements Record {

        private final Piece piece;
        private final int[] source;
        private final int[] target;

        public RecordImpl(Piece piece, int[] source, int[] target) {
            this.piece = piece;
            this.source = source;
            this.target = target;
        }

        @Override
        public Piece piece() {
            return this.piece;
        }

        @Override
        public int[] source() {
            return this.source;
        }

        @Override
        public int[] target() {
            return this.target;
        }

        @Override
        public String toString() {
            return  piece.getRole().getDesc()
                    + "-" + piece.getType().getDesc()
                    + Arrays.toString(piece.getCoord())
                    + ": " + Arrays.toString(source)
                    + "->" + Arrays.toString(target);
        }
    }
}
