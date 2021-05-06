/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author rachelpark
 */
public class LifeController extends JFrame{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    
    private LifeBoard board;
    private LifeView view;
    
    private JButton startButton;
    private JButton stopButton;
    
    private Timer timer;
    private boolean isRunning;
    
    public LifeController(int rows, int cols) {
        super("Rachel's Game of Life");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        isRunning = false;
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!isRunning) {
                    isRunning = true;
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            view.update();
                        }
                    }, 0, 1000);
                }
            }
        });
        buttonPanel.add(startButton);
        
        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isRunning) {
                    timer.cancel();
                    isRunning = false;
                }
            }
        });
        buttonPanel.add(stopButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        board = new LifeBoard(rows, cols);
        view = new LifeView(board);
        view.setSize(WIDTH, HEIGHT - buttonPanel.getHeight());
        add(view, BorderLayout.CENTER);
    }
}
