package com.fsgame.chess.rule.enums.international;

import com.fsgame.chess.rule.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/5 9:04
 * @Description:
 */
public enum IntlBehaviorEnum implements BaseEnum<String> {
      MOVE("走子")
    , CAPTURE("吃子")
    , EN_PASSANT("吃过路兵")
    , CASTLING("王车异位")
    , PROMOTION("升变")
    , NOT_MOVE("未移动")
    ;

    private final String desc;

    IntlBehaviorEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public String getName() {
        return name();
    }
}