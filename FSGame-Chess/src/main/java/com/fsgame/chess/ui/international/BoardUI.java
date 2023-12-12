package com.fsgame.chess.ui.international;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chesspiece.Piece;
import com.fsgame.chess.ui.utils.Controlutil;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: root
 * @Date: 2023/12/11 16:59
 * @Description:
 */
public class BoardUI extends JPanel {

    private static final String PIECE_IMG_PATH = "FSGame-Chess/src/main/resources/images/chess_01/";

    private final Board board;

    public BoardUI(Board board) {
        this.board = board;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < board.rows(); x++) {
            for (int y = 0; y < board.columns(); y++) {
                int xCoord = x * Controlutil.CELLS_SIZE + Controlutil.PADDING;
                int yCoord = y * Controlutil.CELLS_SIZE + Controlutil.PADDING;
                Color color = x % 2 == y % 2 ? Controlutil.CELLS_W : Controlutil.CELLS_B;
                g.setColor(color);
                g.fillRect(yCoord, xCoord, Controlutil.CELLS_SIZE, Controlutil.CELLS_SIZE);

                Piece piece = board.getPiece(x, y);
                if (piece != null) {
                    Image img = Toolkit.getDefaultToolkit()
                            .getImage(Controlutil.getPieceImgPath(piece.getRole(), piece.getType()));
                    g.drawImage(img, yCoord, xCoord, Controlutil.CELLS_SIZE, Controlutil.CELLS_SIZE, this);
                }
            }
        }
    }
}
