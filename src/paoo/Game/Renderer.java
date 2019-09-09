package paoo.Game;

import paoo.Items.Bullet;
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
         * Adding the keyboard listener on the jpanel so we can handle the keys pressed
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
                    //direction: 0->right; 1->left; 2->down; 3->up
                    if(player.getDirection()==2){
                        addObject(new Bullet(player.getSprite().getX(),player.getSprite().getY(),ImageLoader.getInstance().getRockDown(), 6, 2));
                    }
                    if(player.getDirection()==1){
                        addObject(new Bullet(player.getSprite().getX(),player.getSprite().getY(),ImageLoader.getInstance().getRockRight(), 6, 0));
                    }
                    if(player.getDirection()==3){
                        addObject(new Bullet(player.getSprite().getX(),player.getSprite().getY(),ImageLoader.getInstance().getRockLeft(), 6, 1));
                    }
                    if(player.getDirection()==0){
                        addObject(new Bullet(player.getSprite().getX(),player.getSprite().getY(),ImageLoader.getInstance().getRockUp(), 6, 3));
                    }
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
     * Override the paintComponent method in the jpanel so it renders the way we want
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
        player.update(this);
        for(int index=0;index<gameObjects.size();++index){

            gameObjects.get(index).update(this);

            if(gameObjects.get(index) instanceof Bullet)
            {
                int currentX=((Bullet) gameObjects.get(index)).getSprite().getX();
                int currentY=((Bullet) gameObjects.get(index)).getSprite().getY();
                if(currentX>Renderer.WIDTH || currentX<0){
                    gameObjects.remove(gameObjects.get(index));
                }
                if(currentY>Renderer.HEIGHT || currentY<0){
                    gameObjects.remove(gameObjects.get(index));
                }
            }

        }
    }

}
