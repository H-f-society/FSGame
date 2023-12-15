package com.fsgame.chesscore.enums.international;

import com.fsgame.chesscore.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/5 9:04
 * @Description:
 */
public enum IntlBehaviorEnum implements BaseEnum<String> {
      MOVE("Move", "走子")
    , CAPTURE("Capture", "吃子")
    , EN_PASSANT("EnPassant", "吃过路兵")
    , CASTLING("Castling", "王车异位")
    , PROMOTION("Promotion", "升变")
    , NOT_MOVE("NotMove", "未移动")
    ;

    private final String code;
    private final String desc;

    IntlBehaviorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return this.code;
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
