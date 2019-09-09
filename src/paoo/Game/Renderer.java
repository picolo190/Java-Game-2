package paoo.Game;

import paoo.Items.GameObject;
import paoo.Items.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Renderer extends JPanel {


    private Player player;
    private Map map;

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
        super();
        map= new Map();
        player=new Player(100,100,10,4);

        //set the size of the window
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(null);
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
                if(e.getKeyCode()==KeyEvent.VK_S){
                    player.setMovingDown(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    player.setMovingLeft(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    player.setMovingRight(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_W){
                    player.setMovingUp(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_S){
                    player.setMovingDown(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    player.setMovingLeft(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    player.setMovingRight(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_W){
                    player.setMovingUp(false);
                }
            }
        });




    }


    @Override
    public Dimension getPreferredSize(){
        if(isPreferredSizeSet()){
            return super.getPreferredSize();
        }
        return new Dimension(WIDTH,HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g){

        map.render(g);
        player.render(g);
        for(int index=0;index<gameObjects.size();++index){
            gameObjects.get(index).render(g);
        }
    }


    /**
     * This method adds a game object to the game
     * @param object= the game object to be added in the game
     */
    public void addObject(GameObject object){
        gameObjects.add(object);
    }


    public Map getMap(){
        return map;
    }


    /**
     * The update method iterates all the game objects and updates it based on its behaviour
     */
    public void update(){
        player.update();
        for(int index=0;index<gameObjects.size();++index){
            gameObjects.get(index).update();
        }
    }

}
