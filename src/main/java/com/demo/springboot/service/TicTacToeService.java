package com.demo.springboot.service;

import com.demo.springboot.dto.AiMoveDto;
import com.demo.springboot.dto.Board;
import com.demo.springboot.dto.UserMoveDto;

public interface TicTacToeService {
    Board showResultFunction();
    Board restartGameFunction();
    Board usersMoveFunction(UserMoveDto move);
    Board aiMoveFunction(AiMoveDto move);
}

