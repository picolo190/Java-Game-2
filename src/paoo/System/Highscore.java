package paoo.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Highscore extends JPanel {

    private boolean nextState=false;
    private DBConnection dbConnection;
    private Renderer renderer;
    private boolean drawScores=false;

    public Highscore(Renderer renderer)
    {
        //Initialize the JComponents
        super();
        this.renderer=renderer;
        dbConnection=new DBConnection();
        JButton menuButton= new JButton();
        JButton saveScoreButton= new JButton();
        JTextField textField= new JTextField("Enter your name here:");


        //Setting the JTextField
        textField.setBounds(Renderer.WIDTH/2-100, 200,200,50);
        textField.setLayout(null);
        textField.setVisible(true);

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
        menuButton.setBounds(Renderer.WIDTH/2-100,300,200, 50);
        menuButton.setLayout(null);
        menuButton.setVisible(true);

        //Setting the save score button
        saveScoreButton.setText("Save Score");
        saveScoreButton.setBounds(Renderer.WIDTH/2-100,400,200, 50);
        saveScoreButton.setLayout(null);
        saveScoreButton.setVisible(true);

        menuButton.addActionListener(actionEvent -> nextState=true);

        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                textField.setText("");
            }
        });

        saveScoreButton.addActionListener(actionEvent -> {
            String name = textField.getText();
            textField.setText("");
            if(!name.contains("Enter your name here:") && !name.equals("")){
                //write code to access database
                dbConnection.setScore(name,this.renderer.getScore(), this.renderer.getLevel());
                drawScores=false;
            }
        });

        add(menuButton);
        add(saveScoreButton);
        add(textField);
        getScores();

    }

    @Override
    public void paintComponent(Graphics g){
        if(!drawScores){
            if(getComponents()!=null){
                Component[] temp=getComponents();
                for(int i=0; i<temp.length; ++i){
                    if(temp[i] instanceof JLabel){
                        temp[i].setVisible(false);
                    }
                }
                drawScores=false;
                getScores();
            }
        }
        g.drawString("HighScores", Renderer.WIDTH/2-100, 100);
    }

    public boolean getNextState(){
        return nextState;
    }

    public void getScores(){
        dbConnection.getHighScores(this);
    }

    public boolean getDrawScore(){
        return drawScores;
    }

    public void setDrawScores(boolean value){
        drawScores=value;
    }

    public void setNextState(boolean value){
        nextState=value;
    }
}
