package com.fsgame.chess.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: root
 * @Date: 2023/12/15 10:27
 * @Description:
 */
@RestController
@RequestMapping
public class SocketTestController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "SocketTest";
    }
}
