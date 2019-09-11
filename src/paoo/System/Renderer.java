package paoo.System;

import paoo.Entities.Bullet;
import paoo.Entities.GameObject;
import paoo.Entities.Monster;
import paoo.Entities.Player;
import paoo.Map.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Renderer extends JPanel {


    private Player player;
    private Map map;
    private long timeElapsed = 0;

    /**
     * Defining the resolution of the app
     * getting the height on a width/16*9 scale so it has the 16:9 ratio
     */
    public static int WIDTH=1400;
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

        //JLabel for health
        JLabel playerHealth = new JLabel();
        playerHealth.setText(player.getPlayerHealth()+"");
        playerHealth.setVisible(true);
        add(playerHealth);

        timeElapsed=System.currentTimeMillis();

        /**
         * Adding the mouse listener on the JPanel so we can handle the mouse events
         */
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse (x,y) coordinates: "+e.getX()+" "+e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        /**
         * Adding the keyboard listener on the JPanel so we can handle the keys pressed
         */
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN ){
                    player.setMovingDown(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT ){
                    player.setMovingLeft(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT){
                    player.setMovingRight(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP){
                    player.setMovingUp(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    player.setShooting(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN){
                    player.setMovingDown(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT){
                    player.setMovingLeft(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT){
                    player.setMovingRight(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP){
                    player.setMovingUp(false);
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    player.setShooting(false);
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

    /**
     * Override the paintComponent method in the JPanel so it renders the way we want
     * @param g the graphics component of the jpanel
     */
    @Override
    public void paintComponent(Graphics g){

        map.render(g);
        player.render(g);
        for(int index=0;index<gameObjects.size();++index){
            gameObjects.get(index).render(g);
        }
    }

    public ArrayList getObjects(){
        return gameObjects;
    }

    /**
     * This method adds a game object to the game
     * @param object= the game object to be added in the game
     */
    public void addObject(GameObject object){
        gameObjects.add(object);
    }


    /**
     * Getter method for the map
     * @return the map
     */
    public Map getMap(){
        return map;
    }


    /**
     * The update method iterates all the game objects and updates it based on its behaviour
     */
    public void update(){

        System.out.println(gameObjects.size());
        player.update(this);
        System.out.println(player.getPlayerHealth());

        Random r = new Random();
        int xMonster = r.nextInt(Renderer.WIDTH-48*3);
        xMonster+=60;
        int yMonster = r.nextInt(Renderer.HEIGHT-48*3);
        yMonster+=60;

        //Spawn monster on a 3 sec delay
         if(System.currentTimeMillis()-timeElapsed>=3000){
             timeElapsed=System.currentTimeMillis();
             Monster spawnMonster=new Monster(xMonster,yMonster,3,3);
             if(!map.checkCollision(spawnMonster.getSprite())){
                 addObject(spawnMonster);
             }
         }

        for(int index=0;index<gameObjects.size();++index){
            gameObjects.get(index).update(this);
        }
    }

    public Player getPlayer(){
        return player;
    }

}
