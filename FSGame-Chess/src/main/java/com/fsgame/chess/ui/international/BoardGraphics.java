package com.fsgame.chess.ui.international;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chesspiece.Piece;
import com.fsgame.chess.rule.enums.BaseEnum;
import com.fsgame.chess.rule.enums.international.IntlRoleEnum;
import com.fsgame.chess.ui.utils.ControlUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: root
 * @Date: 2023/12/11 17:49
 * @Description:
 */
public class BoardGraphics extends JPanel {

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
                int x = (int) Math.floor((double) (e.getY() - ControlUtil.PADDING) / ControlUtil.CELLS_SIZE);
                int y = (int) Math.floor((double) (e.getX() - ControlUtil.PADDING) / ControlUtil.CELLS_SIZE);

                System.out.print("第 " + clickCount + " 点击..");

                if (clickCount == 0) {
                    clickCount = 1;
                    source = new int[]{x, y};
                } else {
                    clickCount = 0;
                    move(source, new int[]{x, y});
                }
            }
        });
    }

    private void move(int[] source, int[] target) {
        boolean allowMove = board.move(source, target);
        String s = "[" + source[0] + ", " + source[1] + "]";
        String t = "[" + target[0] + ", " + target[1] + "]";
        if (!allowMove) {
            System.out.println("不允许移动：" + s + "->" + t );
            return;
        }
        setPiece(source);
        setPiece(target);
        this.revalidate();
        this.repaint();
        System.out.println(board.getRecords().getLast() + s + "->" + t);
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
        int xCoord = x * ControlUtil.CELLS_SIZE + ControlUtil.PADDING;
        int yCoord = y * ControlUtil.CELLS_SIZE + ControlUtil.PADDING;
        Color color = x % 2 == y % 2 ? ControlUtil.CELLS_W : ControlUtil.CELLS_B;
        if (IntlRoleEnum.B.equals(board.getRoleEnum())) {
            color = x % 2 == y % 2 ? ControlUtil.CELLS_B : ControlUtil.CELLS_W;
        }
        g.setColor(color);
        g.fillRect(yCoord, xCoord, ControlUtil.CELLS_SIZE, ControlUtil.CELLS_SIZE);

        Piece piece = board.getPiece(x, y);
        if (piece != null) {
            Image img = Toolkit.getDefaultToolkit()
                    .getImage(getPieceImgPath(piece.getRole(), piece.getType()));
            g.drawImage(img, yCoord, xCoord, ControlUtil.CELLS_SIZE, ControlUtil.CELLS_SIZE, this);
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