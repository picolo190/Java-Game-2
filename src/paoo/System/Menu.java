package paoo.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {

    //0-menu; 1-game; 2-help
    private int nextState=0;

    public Menu(){
        super();
        JButton playButton= new JButton();
        JButton helpButton= new JButton();
        JButton exitButton= new JButton();

        //set the size of the window
        setPreferredSize(new Dimension(Renderer.WIDTH, Renderer.HEIGHT));
        setVisible(true);
        setLayout(null);
        setFocusable(true);
        requestFocusInWindow();


        //set text
        setFont(new Font("Arial", Font.PLAIN, 30));
        setForeground(Color.BLACK);

        playButton.setText("New game");
        playButton.setBounds(Renderer.WIDTH/2-75,300,150,50);
        playButton.setLayout(null);
        playButton.setVisible(true);
        helpButton.setText("Help");
        helpButton.setBounds(Renderer.WIDTH/2-75,400,150,50);
        helpButton.setLayout(null);
        helpButton.setVisible(true);
        exitButton.setText("Exit");
        exitButton.setBounds(Renderer.WIDTH/2-75,500,150,50);
        exitButton.setLayout(null);
        exitButton.setVisible(true);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                nextState=1;
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                nextState=2;
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        add(playButton);
        add(helpButton);
        add(exitButton);

    }

    @Override
    public void paintComponent(Graphics g){
        g.drawString("Menu",Renderer.WIDTH/2-50,200);
    }

    @Override
    public Dimension getPreferredSize(){
        if(isPreferredSizeSet()){
            return super.getPreferredSize();
        }
        return new Dimension(Renderer.WIDTH,Renderer.HEIGHT);
    }

    public int getNextState(){
        return nextState;
    }

    public void setNextState(int value){
        nextState=value;
    }

}
