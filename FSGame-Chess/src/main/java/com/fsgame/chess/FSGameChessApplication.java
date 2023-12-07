package com.fsgame.chess;

import com.fsgame.chess.chessboard.Board;
import com.fsgame.chess.chessboard.international.IntlChessBoard;
import com.fsgame.chess.enums.international.IntlRoleEnum;

public class FSGameChessApplication {

    public static void main(String[] args) {

        Board board = new IntlChessBoard(IntlRoleEnum.W);

        board.move(new int[]{6, 3}, new int[]{4, 3});
        board.move(new int[]{6, 2}, new int[]{5, 2});
        board.move(new int[]{7, 3}, new int[]{4, 0});
        board.move(new int[]{4, 0}, new int[]{3, 1});
        board.move(new int[]{7, 2}, new int[]{5, 4});

        System.out.println(board);



    }
}
