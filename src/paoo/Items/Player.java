package paoo.Items;

import paoo.Game.ImageLoader;
import paoo.Game.Renderer;

import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * The player class which defines the Player looks and behaviours
 */
public class Player implements GameObject {

    private Rectangle sprite;
    private int playerHealth;
    private int speed;
    private boolean movingUp=false, movingDown=false, movingRight=false, movingLeft=false;

    public Player(int x, int y, int playerHealth, int speed){
        sprite= new Rectangle(x, y,ImageLoader.getInstance().getMonsterLeft());
        this.playerHealth=playerHealth;
        this.speed=speed;
    }

    /**
     * The setter method for the player speed
     * @param xspeed= represents the new player speed
     */
    public void setSpeed(int xspeed){
        speed=xspeed;
    }

    /**
     * The setter method for the player health; the player health gets updated based on this
     * @param health= the new player health
     */
    public void setPlayerHealth(int health){
        playerHealth=health;
    }

    /**
     * The getter method for the player health
     * @return playerHealth= the current player health
     */
    public int getPlayerHealth(){
        return playerHealth;
    }

    @Override
    public void update(){

        if(movingDown){
            sprite.updateY(speed);
        }
        if(movingLeft){
            sprite.updateX(speed*(-1));
        }
        if(movingUp){
            sprite.updateY(speed*(-1));
        }
        if(movingRight){
            sprite.updateX(speed);
        }
    }

    public void setMovingUp(boolean moving){
        movingUp=moving;
    }


    public void setMovingDown(boolean moving){
        movingDown = moving;
    }

    public void setMovingLeft(boolean moving){
        movingLeft=moving;
    }

    public void setMovingRight(boolean moving){
        movingRight=moving;
    }
    /**
     * This method renders the player sprite based on its image and x, y position
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(sprite.getSprite(), sprite.getX(), sprite.getY(), null);

    }
}
