package com.fsgame.chess.rule.enums.international;

import com.fsgame.chess.rule.enums.BaseEnum;

/**
 * @Author: root
 * @Date: 2023/12/4 17:22
 * @Description:
 */
public enum IntlRoleEnum implements BaseEnum<String> {
      W("white", "白色方")
    , B("black", "黑色方")
    ;

    private final String code;

    private final String desc;

    IntlRoleEnum(String code, String desc) {
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
