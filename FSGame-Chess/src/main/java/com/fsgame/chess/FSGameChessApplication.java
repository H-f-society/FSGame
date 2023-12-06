package com.fsgame.chess;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.board.international.IntlChessBoard;
import com.fsgame.chess.chesspiece.Piece;
import com.fsgame.chess.enums.international.IntlRoleEnum;

public class FSGameChessApplication {

    public static void main(String[] args) {

        testInitChessBoard(IntlRoleEnum.W);

        testInitChessBoard(IntlRoleEnum.B);
    }

    public static void testInitChessBoard(IntlRoleEnum intlRoleEnum) {
        Board board = new IntlChessBoard(intlRoleEnum);

        System.out.println(board.getRoleEnum().getDesc());

        board.move(new int[]{6, 1}, new int[]{5, 1});
        board.move(new int[]{6, 2}, new int[]{4, 3});
        board.move(new int[]{7, 1}, new int[]{5, 0});

        for (Piece[] row : board.getBoard()) {
            for (Piece piece : row) {
                System.out.print(piece != null ? piece.getRole().getName() + "."+ piece.getType().getName() : "---");
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
