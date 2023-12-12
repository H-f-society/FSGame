package com.fsgame.chess.ui.international;

import cn.hutool.core.io.FileUtil;
import com.fsgame.chess.rule.enums.international.IntlRoleEnum;
import com.fsgame.chess.ui.utils.ControlUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * @Author: root
 * @Date: 2023/12/11 17:17
 * @Description:
 */
public class RightPanel extends JPanel implements ActionListenerObserver {

    public RightPanel() {
        this.setBackground(ControlUtil.CELLS_B);
        this.setPreferredSize(new Dimension((int)(HomeUI.UI_WIDTH * 0.7), HomeUI.UI_HEIGHT));
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Class B handles event from A");
    }

    @Override
    public void showPieceImg(String configPath) {
        this.removeAll();
        this.setLayout(new FlowLayout());

        String piecePath = ControlUtil.PIECE_IMG + configPath + "/";

        initPieceImg(FileUtil.ls(piecePath + IntlRoleEnum.W.getCode()));
        initPieceImg(FileUtil.ls(piecePath + IntlRoleEnum.B.getCode()));

        this.revalidate();
        this.repaint();
    }

    private void initPieceImg(File[] files) {
        for (File file : files) {
            Image image = Toolkit.getDefaultToolkit().getImage(file.getPath());
            ImageIcon img = new ImageIcon(image.getScaledInstance(ControlUtil.CELLS_SIZE, ControlUtil.CELLS_SIZE, Image.SCALE_SMOOTH));
            this.add(new JLabel(img));
        }
    }
}
