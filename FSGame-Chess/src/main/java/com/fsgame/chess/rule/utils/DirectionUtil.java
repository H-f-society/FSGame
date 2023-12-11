package com.fsgame.chess.rule.utils;

import com.fsgame.chess.rule.enums.DirectionEnum;

import java.util.Set;

/**
 * @Author: root
 * @Date: 2023/12/6 14:56
 * @Description:
 */
public class DirectionUtil {

    public static void allDirection(Set<DirectionEnum> set) {
        straightLineDire(set);
        diagonalLineDire(set);
    }

    public static void straightLineDire(Set<DirectionEnum> set) {
        set.add(DirectionEnum.UP);
        set.add(DirectionEnum.DOWN);
        set.add(DirectionEnum.LEFT);
        set.add(DirectionEnum.RIGHT);
    }

    public static void diagonalLineDire(Set<DirectionEnum> set) {
        set.add(DirectionEnum.LEFT_UP);
        set.add(DirectionEnum.LEFT_DOWN);
        set.add(DirectionEnum.RIGHT_UP);
        set.add(DirectionEnum.RIGHT_DOWN);
    }

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
