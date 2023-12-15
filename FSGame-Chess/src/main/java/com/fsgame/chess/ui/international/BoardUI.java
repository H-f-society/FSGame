package com.fsgame.chess.ui.international;

import com.fsgame.chess.rule.chessboard.international.IntlChessBoard;
import com.fsgame.chess.rule.enums.BaseEnum;
import com.fsgame.chess.ui.utils.PanelStyleUtil;

import javax.swing.*;

/**
 * @Author: root
 * @Date: 2023/12/11 16:59
 * @Description:
 */
public class BoardUI extends JFrame {

    public static final int UI_WIDTH = PanelStyleUtil.CELLS_SIZE * 8 + (PanelStyleUtil.PADDING * 3);
    public static final int UI_HEIGHT = PanelStyleUtil.CELLS_SIZE * 8 + (PanelStyleUtil.PADDING * 4);

    public BoardUI(String configPath, BaseEnum role) {
        this.add(new BoardGraphics(new IntlChessBoard(role), configPath));
        this.setResizable(true);
        this.setSize(UI_WIDTH, UI_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
