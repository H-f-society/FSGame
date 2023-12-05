package com.fsgame.chess;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.board.international.IntlChessBoard;
import com.fsgame.chess.chesspiece.Piece;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FsGameChessApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsGameChessApplication.class, args);

        Board board = new IntlChessBoard();

        System.out.println(board.getRoleEnum().getDesc());

        board.move(new int[]{6, 1}, new int[]{5, 1});

        for (Piece[] row : board.getBoard()) {
            for (Piece piece : row) {
                System.out.print(piece != null ? piece.getRole().getName() + "."+ piece.getType().getName() : "---");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
