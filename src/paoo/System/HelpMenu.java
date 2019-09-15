package paoo.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpMenu extends JPanel {

    private boolean nextState=false;
    public static int selectedSprite=0;

    public HelpMenu(){
        //Calling the JPanel default constructor
        super();

        //Creating the buttons for player sprite selection
        JButton playerSpriteOne = new JButton();
        JButton playerSpriteTwo = new JButton();

        //Create the back button
        JButton backButton = new JButton();

        //Set the size of the window
        setPreferredSize(new Dimension(Renderer.WIDTH, Renderer.HEIGHT));
        setVisible(true);
        setLayout(null);
        setFocusable(true);
        requestFocusInWindow();

        //Set text font
        setFont(new Font("Arial", Font.PLAIN, 30));
        setForeground(Color.BLACK);

        backButton.setLayout(null);
        playerSpriteOne.setLayout(null);
        playerSpriteTwo.setLayout(null);

        //Setting the button's icon
        playerSpriteOne.setIcon(new ImageIcon(ImageLoader.getInstance().getMonsterDown()));
        playerSpriteTwo.setIcon(new ImageIcon(ImageLoader.getInstance().getZeldaDown()));
        playerSpriteOne.setBounds(Renderer.WIDTH/4, 500,
                ImageLoader.getInstance().getMonsterDown().getWidth(), ImageLoader.getInstance().getMonsterDown().getHeight());
        playerSpriteTwo.setBounds(Renderer.WIDTH/4*3, 500,
                ImageLoader.getInstance().getZeldaDown().getWidth(), ImageLoader.getInstance().getZeldaDown().getHeight());


        //Setting the back button
        backButton.setBounds(Renderer.WIDTH/2-75, 300, 150,50);
        backButton.setText("Back to menu");

        //Adding the ActionListeners to the buttons
        backButton.addActionListener(actionEvent -> nextState=true);
        playerSpriteOne.addActionListener(actionEvent -> {
                    selectedSprite = 0;
        });
        playerSpriteTwo.addActionListener(actionEvent -> {
                    selectedSprite = 1;
        });

        add(playerSpriteOne);
        add(playerSpriteTwo);
        add(backButton);
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(ImageLoader.getInstance().getHighScoreBackground(),0,0,null);
        g.drawString("Help", 100,100);
    }

    public boolean getNextState(){
        return nextState;
    }

    public void setNextState(boolean value){
        nextState=value;
    }
}
