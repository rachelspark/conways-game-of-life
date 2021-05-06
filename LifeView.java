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
public class LifeView extends JPanel {
    private static final int GAP = 1;
    private final int ALIVE = 1;
    private final int DEAD = 0;
    
    private LifeBoard board;
    private LifePanel[][] cells;
    
    public LifeView(LifeBoard b) {
        super();
        board = b;
        cells = new LifePanel[board.getRows()][board.getCols()];
        setLayout(new GridLayout(board.getRows(), board.getCols(), GAP, GAP));
        for(int row = 0; row < board.getRows(); row++) {
            for(int col = 0; col < board.getCols(); col++) {
                LifePanel cell = new LifePanel(board, row, col);
                int width = getWidth() / board.getCols();
                int height = getHeight() / board.getRows();
                if(width > height) {
                    cell.setSize(height, height);
                }
                else {
                    cell.setSize(width, width);
                }
                cells[row][col] = cell;
                add(cells[row][col]);
            }
        }
    }

    
    
    public void update() {
        board.step();
        for(int i = 0; i < board.getRows() * board.getCols(); i++) {
            remove(i);
        }
        for(int row = 0; row < board.getRows(); row++) {
            for(int col = 0; col < board.getCols(); col++) {
                cells[row][col] = new LifePanel(board, row, col);
                if(board.getCellState(row,col) == ALIVE) {
                    cells[row][col].setAlive();
                } 
                add(cells[row][col]);
            }
        }
        revalidate();
        repaint();
    }
    
}
