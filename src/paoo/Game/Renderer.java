package paoo.Game;

import paoo.Items.GameObject;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Renderer extends JFrame {
    private JPanel gamePanel;

    /**
     * Defining the resolution of the app
     * getting the height on a width/16*9 scale so it has the 16:9 ratio
     */
    public static int WIDTH=1600;
    public static int HEIGHT=WIDTH/16*9;

    /**
     * The array list to be iterated and handle all the game objects in game
     */
    private ArrayList<GameObject> gameObjects=new ArrayList<>();


    public Renderer(){
        //initialise the jpanel
        gamePanel = new javax.swing.JPanel();

        //this tells the game to close when the close button of the window is pressed; it can be called a handler
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //set the window title to "Game"
        setTitle("Game");

        //set the size of the window
        setPreferredSize(new java.awt.Dimension(WIDTH, HEIGHT));

        //the panel is resizeable so the minimum size must be set
        gamePanel.setMinimumSize(new java.awt.Dimension(WIDTH, HEIGHT));

        //also the set the size of the panel; the panel is part of the window
        gamePanel.setSize(new java.awt.Dimension(WIDTH, HEIGHT));
        gamePanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();

        requestFocusInWindow();
        setLocationRelativeTo(null);
        setVisible(true);

        /**
         * Adding the keyboard listener on the jpanel so we can handle the keys pressed
         */
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        /**
         * Adding the mouse listener on the jpanel so we can handle the mouse events
         */
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked on the x:"+e.getX()+" y:"+e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //code to be executed when mouse button is pressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //code to be executed when mouse button is released
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //code to be executed when mouse pointer enters the panel
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //code to be executed when the mouse pointer leaves the panel
            }
        });
    }


    /**
     * This method adds a game object to the game
     * @param object= the game object to be added in the game
     */
    public void addObject(GameObject object){
        gameObjects.add(object);
    }

    /**
     * This method iterates all the game objects and renders it on the screen
     */
    public void render(){
        for(int index=0;index<gameObjects.size();++index){
            gameObjects.get(index).render();
        }
    }

    /**
     * The update method iterates all the game objects and updates it based on its behaviour
     */
    public void update(){
        for(int index=0;index<gameObjects.size();++index){
            gameObjects.get(index).update();
        }
    }

    /**
     * This is a getter method for the game panel
     * @return the game panel
     */
    public JPanel getGamePanel(){
        return gamePanel;
    }
}
