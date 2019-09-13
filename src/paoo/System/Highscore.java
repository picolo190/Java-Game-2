package paoo.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Highscore extends JPanel {

    private boolean nextState=false;

    public Highscore()
    {
        //Initialize the JComponents
        super();
        JButton menuButton= new JButton();
        JButton saveScoreButton= new JButton();


        //set the size of the window
        setPreferredSize(new Dimension(Renderer.WIDTH, Renderer.HEIGHT));
        setVisible(true);
        setLayout(null);
        setFocusable(true);
        requestFocusInWindow();

        //set text
        setFont(new Font("Arial", Font.PLAIN, 30));
        setForeground(Color.BLACK);

        //Setting the menu button
        menuButton.setText("Back to menu");
        menuButton.setBounds(100,100,150, 50);
        menuButton.setLayout(null);
        menuButton.setVisible(true);

        //Setting the save score button
        saveScoreButton.setText("Save Score");
        saveScoreButton.setBounds(100,200,150, 50);
        saveScoreButton.setLayout(null);
        saveScoreButton.setVisible(true);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                nextState=true;
            }
        });

        saveScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        add(menuButton);
        add(saveScoreButton);

    }

    @Override
    public void paintComponent(Graphics g){
        g.drawString("HighScores", Renderer.WIDTH/2, Renderer.HEIGHT/2);
    }

    public boolean getNextState(){
        return nextState;
    }

    public void setNextState(boolean value){
        nextState=value;
    }
}
