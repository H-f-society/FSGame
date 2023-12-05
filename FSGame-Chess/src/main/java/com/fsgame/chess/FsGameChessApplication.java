package com.fsgame.chess;

import com.fsgame.chess.board.Board;
import com.fsgame.chess.board.international.IntlChessBoard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FsGameChessApplication {

    public static void main(String[] args) {
        SpringApplication.run(FsGameChessApplication.class, args);

        Board board = new IntlChessBoard();

        System.out.println(board);
        // new WalkingRecords.Builder().source(new int[]{1, 2}).target(new int[]{1, 2}).piece(new King()).build();
    }

}
