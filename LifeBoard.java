/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author rachelpark
 */
public class LifeBoard {
    private final int ALIVE = 1;
    private final int DEAD = 0;
    
    private int[][] cells;
    
    
    public LifeBoard(int rows, int cols) {
        cells = new int[rows][cols];
    }
    
    public int getRows() {
        return cells.length;
    }
    
    public int getCols() {
        return cells[0].length;
    }
    
    public int getCellState(int r, int c) {
        return cells[r][c];
    }
    
    public void setCellState(int r, int c, int x) {
        cells[r][c] = x;
    }

    private int aliveNeighborCount(int r, int c) {
        int neighborCount = 0;
        if(r > 0 && c > 0) {
            if(cells[r-1][c-1] == ALIVE) 
                neighborCount++;
        }
        if(r > 0) {
            if(cells[r-1][c] == ALIVE)
                neighborCount++;
        }

        if(r > 0 && c < cells[0].length - 1) {
           if(cells[r-1][c+1] == ALIVE)
                neighborCount++;
        }
                
        if(c > 0) {
            if(cells[r][c-1] == ALIVE)
                neighborCount++;
        }
                
        if(c < cells[0].length - 1) {
            if(cells[r][c+1] == ALIVE)
                neighborCount++;
        }
		
        if(r < cells.length - 1 && c > 0) {
            if(cells[r+1][c-1] == ALIVE)
                neighborCount++;
        }	
		
        if(r < cells.length - 1) {
            if(cells[r + 1][c] == ALIVE)
                neighborCount++;
        }
               
        if(r < cells.length - 1 && c < cells[0].length - 1) {
            if(cells[r+1][c+1] == ALIVE)
                neighborCount++;
        }
            
        return neighborCount;
    }
    
    public int nextState(int r, int c) {
        int neighbors = aliveNeighborCount(r, c);
                if ((cells[r][c] == ALIVE) && ((neighbors == 3) || (neighbors == 2))) {
                    return ALIVE;
                }
                else if ((cells[r][c] == DEAD) && (neighbors == 3)) {
                    return ALIVE;
                }
                return DEAD;
    }

    public void step() {
        int[][] nextStates = new int[cells.length][cells[0].length];
        for(int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                nextStates[row][col] = nextState(row, col);
            }
        }
        for(int row = 0; row < cells.length; row++) {
            for(int col = 0; col < cells[0].length; col++) {
                cells[row][col] = nextStates[row][col];
            }
        }
    }
}
