package com.fsgame.chess.enums.international;

import com.fsgame.chess.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 15:03
 * @Description:
 */
public enum IntlPieceEnum implements BaseEnum<String> {
      K("King", "国王")
    , Q("Queen", "皇后")
    , B("Bishop", "主教")
    , N("Knight", "骑士")
    , R("Rook", "战车")
    , P("Pawn", "兵卒")
    ;

    private final String code;

    private final String desc;

    IntlPieceEnum(String code, String desc) {
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
