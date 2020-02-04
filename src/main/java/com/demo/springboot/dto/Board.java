package com.demo.springboot.dto;

import lombok.ToString;
import org.springframework.stereotype.Repository;

@ToString
@Repository
public class Board {
    public Character[][] gameBoard;

    public Board()
    {
        this.gameBoard=new Character[3][3];
    }
}

