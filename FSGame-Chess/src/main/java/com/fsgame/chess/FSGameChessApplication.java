package com.fsgame.chess;

import com.fsgame.chess.ui.international.HomeUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FSGameChessApplication {

    private static final Logger logger = LoggerFactory.getLogger(FSGameChessApplication.class);

    public static void main(String[] args) {

        // SpringApplication.run(FSGameChessApplication.class, args);

        HomeUI home = new HomeUI();



    }
}
