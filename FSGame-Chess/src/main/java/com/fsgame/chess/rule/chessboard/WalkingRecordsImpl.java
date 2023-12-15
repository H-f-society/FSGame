package com.fsgame.chess.rule.chessboard;

import com.fsgame.chess.rule.enums.BaseEnum;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: root
 * @Date: 2023/12/15 14:49
 * @Description:
 */
public class WalkingRecordsImpl implements WalkingRecords {

    private final BaseEnum behavior;

    private final List<Record> records;

    public WalkingRecordsImpl(BaseEnum behavior, List<Record> records) {
        this.behavior = behavior;
        this.records = records;
    }


    @Override
    public BaseEnum getBehavior() {
        return behavior;
    }

    @Override
    public List<Record> getRecords() {
        return records;
    }

    public static class Builder {

        private BaseEnum behavior;

        private final List<Record> records;

        public Builder() {
            this.records = new LinkedList<>();
        }

        public Builder record(Record record) {
            this.records.add(record);
            return this;
        }

        public Builder behavior(BaseEnum behavior) {
            this.behavior = behavior;
            return this;
        }

        public WalkingRecordsImpl build() {
            return new WalkingRecordsImpl(behavior, records);
        }

    }
}
