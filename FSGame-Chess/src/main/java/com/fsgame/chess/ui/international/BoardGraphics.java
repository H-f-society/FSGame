package com.fsgame.chess.ui.international;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chesspiece.Piece;
import com.fsgame.chess.rule.enums.international.IntlRoleEnum;
import com.fsgame.chess.ui.utils.ControlUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: root
 * @Date: 2023/12/11 17:49
 * @Description:
 */
public class BoardGraphics extends JPanel {

    private final Board board;

    public BoardGraphics(Board board) {
        this.board = board;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < board.rows(); x++) {
            for (int y = 0; y < board.columns(); y++) {
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
                            .getImage(ControlUtil.getPieceImgPath(piece.getRole(), piece.getType()));
                    g.drawImage(img, yCoord, xCoord, ControlUtil.CELLS_SIZE, ControlUtil.CELLS_SIZE, this);
                }
            }
        }
    }
}
