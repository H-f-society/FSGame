package com.fsgame.chess;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chessboard.international.IntlChessBoard;
import com.fsgame.chess.enums.international.IntlRoleEnum;

public class FSGameChessApplication {

    public static void main(String[] args) {

        Board board = new IntlChessBoard(IntlRoleEnum.W);

        board.move(new int[]{6, 3}, new int[]{4, 3});
        System.out.println(board);
        board.move(new int[]{4, 3}, new int[]{3, 3});
        System.out.println(board);
        // board.move(new int[]{1, 4}, new int[]{2, 4});
        // board.move(new int[]{2, 4}, new int[]{3, 4});
        board.move(new int[]{1, 4}, new int[]{3, 4});
        System.out.println(board);
        board.move(new int[]{3, 3}, new int[]{2, 4});
        System.out.println(board);
        // board.move(new int[]{3, 3}, new int[]{2, 3});
        // board.move(new int[]{2, 3}, new int[]{1, 3});
        // board.move(new int[]{6, 2}, new int[]{5, 2});
        // System.out.println(board);
        // board.move(new int[]{7, 3}, new int[]{4, 0});
        // System.out.println(board);
        // board.move(new int[]{2, 4}, new int[]{1, 3});
        // System.out.println(board);
        // board.move(new int[]{4, 0}, new int[]{1, 3});
        // System.out.println(board);
        //
        // board.move(new int[]{1, 3}, new int[]{0, 2});
        // System.out.println(board);


        // board.move(new int[]{7, 2}, new int[]{5, 4});

        // board.swap(new int[]{0, 0}, new int[]{1, 1});

        // System.out.println(board);

        // Board board1 = new IntlChessBoard(IntlRoleEnum.B);
        // System.out.println(board1);



    }
}
