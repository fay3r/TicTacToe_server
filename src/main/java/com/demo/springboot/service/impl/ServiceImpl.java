package com.demo.springboot.service.impl;

import com.demo.springboot.dto.AiMoveDto;
import com.demo.springboot.dto.Board;
import com.demo.springboot.dto.UserMoveDto;
import com.demo.springboot.service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ServiceImpl implements TicTacToeService {

    @Autowired
    private Board board;

    @Override
    public Board showResultFunction() {
        return board;
    }

    @Override
    public Board restartGameFunction() {
        board=new Board();
        return board;
    }

    @Override
    public Board usersMoveFunction(UserMoveDto move) {
        Character tmp = board.gameBoard[Integer.parseInt(move.getFieldX())-1][Integer.parseInt(move.getFieldY())-1] ;
        if(tmp!=null){
            return null;}
        board.gameBoard[Integer.parseInt(move.getFieldX())-1][Integer.parseInt(move.getFieldY())-1] = move.getMark();
        return board;
    }

    @Override
    public Board aiMoveFunction(AiMoveDto move) {
        Random rand = new Random();
        for(int i=0;i<board.gameBoard.length;i++){
            for(int j=0;j<board.gameBoard[i].length;j++){
                if(board.gameBoard[i][j]==null){
                    while(true){
                        int x = rand.nextInt(3);
                        int y = rand.nextInt(3);
                        Character tmp = board.gameBoard[x][y];
                        System.out.println(x + " " + y + " " + tmp);
                        if (tmp == null){
                            System.out.println("#END");
                            board.gameBoard[x][y] = move.getMark();
                            break;
                        }
                    }
                    return board;
                }
            }
        }
        return null;
    }
}
