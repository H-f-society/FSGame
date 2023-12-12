package com.fsgame.chess.ui.international;

import java.awt.event.ActionEvent;

/**
 * @Author: root
 * @Date: 2023/12/12 16:53
 * @Description:
 */
public interface ActionListenerObserver {

    void actionPerformed(ActionEvent event);

    void showPieceImg(String configPath);
}
