package com.fsgame.chess;

import com.fsgame.chess.rule.chessboard.Board;
import com.fsgame.chess.rule.chessboard.international.IntlChessBoard;
import com.fsgame.chess.rule.enums.international.IntlRoleEnum;
import com.fsgame.chess.ui.international.BoardUI;
import com.fsgame.chess.ui.international.HomeUI;


public class FSGameChessApplication {

    public static void main(String[] args) {


        HomeUI home = new HomeUI();

        // Board board = new IntlChessBoard(IntlRoleEnum.W);
        //
        // board.move(new int[]{6, 3}, new int[]{4, 3});
        // System.out.println(board);
        // board.move(new int[]{4, 3}, new int[]{3, 3});
        // System.out.println(board);
        // // // board.move(new int[]{1, 4}, new int[]{2, 4});
        // // // board.move(new int[]{2, 4}, new int[]{3, 4});
        // board.move(new int[]{1, 4}, new int[]{3, 4});
        // System.out.println(board);
        // board.move(new int[]{3, 3}, new int[]{2, 4});
        // System.out.println(board);
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
        // // board.move(new int[]{1, 3}, new int[]{0, 2});
        // // System.out.println(board);
        //
        // System.out.println(board.move(new int[]{7, 2}, new int[]{6, 3}));
        //
        // System.out.println(board.move(new int[]{7, 1}, new int[]{5, 0}));
        // System.out.println(board);
        //
        //
        // // board.move(new int[]{7, 2}, new int[]{5, 4});
        //
        // // board.swap(new int[]{0, 0}, new int[]{1, 1});
        //
        // // System.out.println(board);
        //
        // board.move(new int[]{7, 4}, new int[]{7, 0}); // 我方白向左异位
        // // board.move(new int[]{0, 4}, new int[]{0, 0}); // 敌方黑向左异位
        // // board.move(new int[]{7, 4}, new int[]{7, 7}); // 我方白向右异位
        // // board.move(new int[]{0, 4}, new int[]{0, 7}); // 敌方黑向左异位
        //
        // // board.move(new int[]{7, 3}, new int[]{7, 0}); // 我方黑向左异位
        // // board.move(new int[]{0, 3}, new int[]{0, 0}); // 敌方白向左异位
        // // board.move(new int[]{7, 3}, new int[]{7, 7}); // 我方黑向右异位
        // // board.move(new int[]{0, 3}, new int[]{0, 7}); // 敌方白向左异位
        //
        // System.out.println(board);

        // Board board1 = new IntlChessBoard(IntlRoleEnum.B);
        // System.out.println(board1);



    }
}
