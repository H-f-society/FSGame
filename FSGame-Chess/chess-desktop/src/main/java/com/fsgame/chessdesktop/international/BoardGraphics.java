package com.fsgame.chessdesktop.international;

import com.fsgame.chesscore.chessboard.Board;
import com.fsgame.chesscore.chesspiece.Piece;
import com.fsgame.chesscore.enums.BaseEnum;
import com.fsgame.chesscore.enums.international.IntlBehaviorEnum;
import com.fsgame.chesscore.enums.international.IntlRoleEnum;
import com.fsgame.chessdesktop.utils.PanelStyleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

/**
 * @Author: root
 * @Date: 2023/12/11 17:49
 * @Description:
 */
public class BoardGraphics extends JPanel {

    private static final Logger logger = LoggerFactory.getLogger(BoardGraphics.class);

    private final Board board;

    private final String configPath;

    private Graphics g;

    private int clickCount = 0;

    private int[] source = {};

    public BoardGraphics(Board board, String configPath) {
        this.board = board;
        this.configPath = configPath;
    }

    {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = (int) Math.floor((double) (e.getY() - PanelStyleUtil.PADDING) / PanelStyleUtil.CELLS_SIZE);
                int y = (int) Math.floor((double) (e.getX() - PanelStyleUtil.PADDING) / PanelStyleUtil.CELLS_SIZE);

                logger.info("第 {} 点击... ", clickCount % 2 == 0 ? 0 : 1);

                if (clickCount % 2 == 0) {
                    source = new int[]{x, y};
                } else {
                    move(source, new int[]{x, y});
                }
                clickCount++;
            }
        });
    }

    private void move(int[] source, int[] target) {
        boolean allowMove = board.move(source, target);
        if (!allowMove) {
            logger.info("{}: {} -> {}", IntlBehaviorEnum.NOT_MOVE.getDesc(), Arrays.toString(source), Arrays.toString(target));
            return;
        }
        this.revalidate();
        this.repaint();
        logger.info("{}: {}", board.getRecords().getLast().getBehavior().getDesc(), board.getRecords().getLast().getRecords().toString());
    }

    @Override
    public void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(this.g);

        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.columns(); j++) {
                setPiece(i, j);
            }
        }
    }

    private void setPiece(int[] coord) {
        setPiece(coord[0], coord[1]);
    }

    private void setPiece(int x, int y) {
        int xCoord = x * PanelStyleUtil.CELLS_SIZE + PanelStyleUtil.PADDING;
        int yCoord = y * PanelStyleUtil.CELLS_SIZE + PanelStyleUtil.PADDING;
        Color color = x % 2 == y % 2 ? PanelStyleUtil.CELLS_W : PanelStyleUtil.CELLS_B;
        if (IntlRoleEnum.B.equals(board.getRoleEnum())) {
            color = x % 2 == y % 2 ? PanelStyleUtil.CELLS_B : PanelStyleUtil.CELLS_W;
        }
        g.setColor(color);
        g.fillRect(yCoord, xCoord, PanelStyleUtil.CELLS_SIZE, PanelStyleUtil.CELLS_SIZE);

        Piece piece = board.getPiece(x, y);
        if (piece != null) {
            Image img = Toolkit.getDefaultToolkit()
                    .getImage(getPieceImgPath(piece.getRole(), piece.getType()));
            g.drawImage(img, yCoord, xCoord, PanelStyleUtil.CELLS_SIZE, PanelStyleUtil.CELLS_SIZE, this);
        }
    }

    private String getPieceImgPath(BaseEnum role, BaseEnum piece) {
        StringBuilder sb = new StringBuilder();
        sb.append(configPath)
                .append("/")
                .append(role.getCode())
                .append("/")
                .append(piece.getCode())
                .append(".png");
        return sb.toString();
    }
}
