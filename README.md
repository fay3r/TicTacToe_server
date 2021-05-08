# TicTacToe_server

About: <br>
Tic Tac Toe server made for handling actual state of the game. Game vs stupid AI

| Method  |       URL                    |  Request body                          | Response body | Comment|
| ------------- | ------------- | ------------- | ------------- | ------------- | 
| GET | /ticktacktoe/result | <center><b>--- | HTTP 200 -  { "gameBoard":[[null, X, null], [O, null, null], [null, null, null]] } | used to get current board state |
| POST | /ticktacktoe/reset-game | <center><b>--- |HTTP 200 -  { "gameBoard":[[null, null, null], [null, null, null], [null, null, null]] } | used to reset current board state |
| POST | /ticktacktoe/set-field-by-user | { "fieldX":"fieldX", "fieldY":"fieldY", "mark":"mark" } |HTTP 200 -  returns board with new mark, HTTP 403 - field already set | used to set users mark on a field  |
| POST | /ticktacktoe/set-field-by-ai | { "mark":"mark" } | HTTP 200 -  returns board with new mark, HTTP 403 - field already set  | used to set AI mark on a field |
