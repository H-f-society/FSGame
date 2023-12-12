package com.fsgame.chess.ui.international;

import com.fsgame.chess.rule.chessboard.international.IntlChessBoard;
import com.fsgame.chess.ui.utils.ControlUtil;

import javax.swing.*;

/**
 * @Author: root
 * @Date: 2023/12/11 16:59
 * @Description:
 */
public class BoardUI extends JFrame {

    public static final int UI_WIDTH = ControlUtil.CELLS_SIZE * 8 + (ControlUtil.PADDING * 3);
    public static final int UI_HEIGHT = ControlUtil.CELLS_SIZE * 8 + (ControlUtil.PADDING * 3);

    public BoardUI() {
        this.add(new BoardGraphics(new IntlChessBoard()));
        this.setResizable(true);
        this.setSize(UI_WIDTH, UI_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
