package com.fsgame.chessdesktop.international;

import com.fsgame.chessdesktop.utils.PanelStyleUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: root
 * @Date: 2023/12/11 16:54
 * @Description:
 */
public class HomeUI extends JFrame {

    public static final int UI_WIDTH = PanelStyleUtil.CELLS_SIZE * 8;
    public static final int UI_HEIGHT = PanelStyleUtil.CELLS_SIZE * 6;

    LeftPanel leftPanel = new LeftPanel();
    RightPanel rightPanel = new RightPanel();

    public HomeUI() {
        // this.add(new BoardUI(new IntlChessBoard(IntlRoleEnum.W)));
        this.setResizable(true);
        this.setSize(UI_WIDTH, UI_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        this.setVisible(true);
    }

    public void init() {
        this.setLayout(new BorderLayout());
        leftPanel.setObserver(rightPanel);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.CENTER);
    }
}
