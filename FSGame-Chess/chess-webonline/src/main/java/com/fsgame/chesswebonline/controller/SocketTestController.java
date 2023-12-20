package com.fsgame.chesswebonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: root
 * @Date: 2023/12/15 10:27
 * @Description:
 */
@Controller
@RequestMapping
public class SocketTestController {

    @GetMapping("/test")
    public String test() {
        return "WebSocket";
    }
}
