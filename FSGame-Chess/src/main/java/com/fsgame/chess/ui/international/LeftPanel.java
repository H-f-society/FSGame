package com.fsgame.chess.ui.international;

import cn.hutool.core.io.FileUtil;
import com.fsgame.chess.rule.enums.BaseEnum;
import com.fsgame.chess.rule.enums.international.IntlRoleEnum;
import com.fsgame.chess.ui.utils.ControlUtil;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @Author: root
 * @Date: 2023/12/12 16:13
 * @Description:
 */
public class LeftPanel extends JPanel {


    private BaseEnum role = IntlRoleEnum.W;
    private String configPath = FileUtil.ls(ControlUtil.PIECE_IMG)[0].getPath();

    private ActionListenerObserver observer;

    private final JButton gameStart = new JButton("开始对弈");

    {
        gameStart.addActionListener(e -> new BoardUI(configPath, role));

    }

    public LeftPanel() {
        initRoleRaio();
        initConfigRadio();
        initControl();

        this.setBackground(ControlUtil.CELLS_W);
        this.setPreferredSize(new Dimension((int)(HomeUI.UI_WIDTH * 0.3), HomeUI.UI_HEIGHT));

        this.setLayout(new FlowLayout());
    }

    private void initControl() {
        this.add(gameStart);
    }

    private void initRoleRaio() {
        ButtonGroup group = new ButtonGroup();

        for (BaseEnum role : IntlRoleEnum.values()) {
            JRadioButton radio = new JRadioButton(role.getDesc());
            radio.addActionListener(e -> {
                setRole(role);
            });
            this.add(radio);
            group.add(radio);
        }
    }

    private void initConfigRadio() {

        this.setLayout(new BorderLayout());
        File[] dirs = FileUtil.ls(ControlUtil.PIECE_IMG);
        ButtonGroup group = new ButtonGroup();
        for (File config : dirs) {
            String name = config.getName();
            JRadioButton radio = new JRadioButton(name);
            radio.addActionListener(e -> {
                setConfigPath(config.getPath());
                // 当按钮被点击时，通知观察者
                if (observer != null) {
                    observer.showPieceImg(name);
                }
            });
            this.add(radio);
            group.add(radio);
        }
    }

    public void setObserver(ActionListenerObserver observer) {
        this.observer = observer;
    }

    public void setRole(BaseEnum role) {
        this.role = role;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public String getConfigPath() {
        return configPath;
    }


}
