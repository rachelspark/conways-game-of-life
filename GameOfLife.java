/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
/**
 *
 * @author rachelpark
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the desired size of the board:");
        int rows = keyboard.nextInt();
        int cols = keyboard.nextInt();
        
        LifeController gameOfLife = new LifeController(rows,cols);
        gameOfLife.setVisible(true);
    }
    
}
