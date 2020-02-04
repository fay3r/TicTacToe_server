package com.demo.springboot.rest;

import com.demo.springboot.dto.AiMoveDto;
import com.demo.springboot.dto.Board;
import com.demo.springboot.dto.UserMoveDto;
import com.demo.springboot.service.TicTacToeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticktacktoe")
public class ApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private TicTacToeService action;
    @Autowired
    private Board board;

    @CrossOrigin
    @GetMapping(value = "/result")
    public ResponseEntity showResult() {
        board=action.showResultFunction();
        return new ResponseEntity(board, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/reset-game")
    public ResponseEntity resetGame() {
        board=action.restartGameFunction();
        return new ResponseEntity(board, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/set-field-by-user")
    public ResponseEntity usersMove(@RequestBody UserMoveDto userMoveDto) {
        board=action.usersMoveFunction(userMoveDto);
        return new ResponseEntity(board,HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/set-field-by-ai")
    public ResponseEntity aiMove(@RequestBody AiMoveDto aiMoveDto) {
        board=action.aiMoveFunction(aiMoveDto);
        return new ResponseEntity(board,HttpStatus.OK);
    }
}