/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author bruno
 */

public class Logic {
    private final int[][] board;
    private int player;

    public Logic() {
        board = new int[3][3];
        player = 1;
        
        int number = 3;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = number;
                number++;
            }
        }
    }
    
    public void play(int y, int x) {
        if (isPlayed(y, x)) {
            return;
        }
        
        if (checkWinner()) {
            return;
        }
                
        board[x][y] = player;
        changePlayer();
    }
    
    public boolean isPlayed(int y, int x) {
        return board[x][y] == 1 || board[x][y] == 2;
    }
    
    private void changePlayer() {
        if (player == 1) {
            player = 2;
        } else {
            player = 1;
        }
    }
    
    public String getPlayer() {
        if (player == 1) {
            return "X";
        } else {
            return "O";
        }
    }
    
    public void printBoard() {
        StringBuilder build = new StringBuilder();
        
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                build.append(board[x][y] + " ");
            }
            
            build.append("\n");
        }
        
        System.out.println(build);
    }
    
    public boolean checkWinner() {
        return board[0][0] == board[1][0] && board[1][0] == board[2][0] ||
                board[0][1] == board[1][1] && board[1][1] == board[2][1] ||
                board[0][2] == board[1][2] && board[1][2] == board[2][2] ||
                board[0][0] == board[0][1] && board[0][1] == board[0][2] ||
                board[1][0] == board[1][1] && board[1][1] == board[1][2] ||
                board[2][0] == board[2][1] && board[2][1] == board[2][2] ||
                board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                board[2][0] == board[1][1] && board[1][1] == board[0][2];
    }
}
