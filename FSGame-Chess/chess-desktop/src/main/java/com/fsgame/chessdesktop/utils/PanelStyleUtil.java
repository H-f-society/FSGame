package com.fsgame.chessdesktop.utils;

import com.fsgame.chesscore.enums.BaseEnum;

import java.awt.*;

/**
 * @Author: root
 * @Date: 2023/12/11 17:04
 * @Description:
 */
public class PanelStyleUtil {

    public static final int[] BUTTON_SIZE = {200, 100};

    public static final int PADDING = 15;
    public static final int CELLS_SIZE = 80;
    public static final int BOARD_SIZE = 640;
    public static final Color CELLS_W = new Color(199, 196, 153);
    public static final Color CELLS_B = new Color(127, 74, 56);

    private static final String PIECE_IMG_PATH = "FSGame-Chess/chess-desktop/src/main/resources/international/images/chess_01/";

    public static final String PIECE_IMG = "international/images/";

    public static String getPieceImgPath(BaseEnum role, BaseEnum piece) {
        StringBuilder sb = new StringBuilder();
        sb.append(PIECE_IMG_PATH)
            .append(role.getCode())
            .append("/")
            .append(piece.getCode())
            .append(".png");
        return sb.toString();
    }



    // public static File[] getChessConfig() {
    //     for (File dir : FileUtil.ls("images")) {
    //
    //     }
    // }
}
