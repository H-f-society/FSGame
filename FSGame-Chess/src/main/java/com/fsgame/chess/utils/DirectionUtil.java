package com.fsgame.chess.utils;

import com.fsgame.chess.enums.DirectionEnum;

/**
 * @Author: root
 * @Date: 2023/12/6 14:56
 * @Description:
 */
public class DirectionUtil {

    public static DirectionEnum calcDirection(int[] source, int[] target) {
        int x = target[0] - source[0];
        int y = target[1] - source[1];
        if (x == 0 && y == 0) {
            return DirectionEnum.IN_SITU;
        }
        if (x < 0 && y == 0) {
            return DirectionEnum.UP;
        }
        if (x > 0 && y == 0) {
            return DirectionEnum.DOWN;
        }
        if (x == 0 && y < 0) {
            return DirectionEnum.LEFT;
        }
        if (x == 0 && y > 0) {
            return DirectionEnum.RIGHT;
        }
        if (Math.abs(x) == Math.abs(y)) {
            if (x < 0 && y < 0) {
                return DirectionEnum.LEFT_UP;
            }
            if (x < 0 && y > 0) {
                return DirectionEnum.RIGHT_UP;
            }
            if (x > 0 && y < 0) {
                return DirectionEnum.LEFT_DOWN;
            }
            if (x > 0 && y > 0) {
                return DirectionEnum.RIGHT_DOWN;
            }
        }
        return DirectionEnum.SPECIFIED;
    }
}
