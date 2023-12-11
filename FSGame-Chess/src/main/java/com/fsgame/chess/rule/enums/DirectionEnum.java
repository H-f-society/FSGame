package com.fsgame.chess.rule.enums;

/**
 * @Author: root
 * @Date: 2023/12/6 14:52
 * @Description:
 */
public enum DirectionEnum implements BaseEnum<String> {
      UP("正上方")
    , DOWN("正下方")
    , LEFT("正左方")
    , RIGHT("正右方")
    , LEFT_UP("正斜左上方")
    , LEFT_DOWN("正斜左下方")
    , RIGHT_UP("正斜右上方")
    , RIGHT_DOWN("正斜右下方")
    , SPECIFIED("指定位置的")
    , IN_SITU("在原位")
    ;

    private final String desc;

    DirectionEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
