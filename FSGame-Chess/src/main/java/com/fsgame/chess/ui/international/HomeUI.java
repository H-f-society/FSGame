package com.fsgame.chess.ui.international;

import com.fsgame.chess.rule.chessboard.international.IntlChessBoard;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: root
 * @Date: 2023/12/11 16:54
 * @Description:
 */
public class HomeUI extends JFrame {

    private static final int UI_WIDTH = 685;
    private static final int UI_HEIGHT = 705;

    private final JPanel jPanelLeft = new JPanel();
    private final JPanel jPanelRight = new JPanel();

    public HomeUI() {
        this.add(new BoardUI(new IntlChessBoard()));
        this.setResizable(true);
        this.setSize(UI_WIDTH, UI_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void init() {
        // this.setLayout(new BorderLayout());
        // this.add(jPanelLeft, BorderLayout.EAST);
        // this.add(jPanelRight, BorderLayout.WEST);
    }
}
