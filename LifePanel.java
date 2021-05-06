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
public class LifePanel extends JPanel implements MouseListener {
    private LifeBoard board;
    private int row, col, state;
    private final Color ALIVE_COLOR = Color.CYAN;
    private final Color DEAD_COLOR = Color.LIGHT_GRAY;
    
    public LifePanel(LifeBoard b, int r, int c) {
        super();
        board = b;
        row = r;
        col = c;
        state = b.getCellState(r, c);
        
        if(state % 2 == 0) setDead();
        else setAlive();
        addMouseListener(this);
    }
    
    public void setAlive() {
        board.setCellState(row, col, 1);
        setBackground(ALIVE_COLOR);
    }
    
    public void setDead() {
        board.setCellState(row, col, 0);
        setBackground(DEAD_COLOR);
    }
    
    public boolean isAlive() {
        return (getBackground().equals(Color.CYAN));
    }
    
    
    public void mouseClicked(MouseEvent e) {
        if(getBackground() == ALIVE_COLOR) {
            setDead();
        }
        else {
            setAlive();
        }
    }
    
    public void mouseEntered(MouseEvent e) {
        
    }
    public void mouseExited(MouseEvent e) {
        
    }
    public void mousePressed(MouseEvent e) {
        
    }
    public void mouseReleased(MouseEvent e) {
        
    }

   
}
