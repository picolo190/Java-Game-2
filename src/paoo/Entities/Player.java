package paoo.Entities;

import paoo.System.ImageLoader;
import paoo.System.Renderer;
import java.awt.*;

/**
 * The player class which defines the Player looks and behaviours
 */
public class Player implements GameObject {

    private Rectangle sprite;
    private int playerHealth;
    private int speed;
    //0-up, 1-right, 2-down, 3-left
    private int direction;
    private boolean movingUp=false, movingDown=false, movingRight=false, movingLeft=false;

    public Player(int x, int y, int playerHealth, int speed){
        sprite= new Rectangle(x, y,ImageLoader.getInstance().getMonsterLeft());
        direction=3;
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
    public void update(Renderer renderer){

        int xCollisionOffset=5;
        int yCollisionOffset=5;

        Rectangle collisionCheckRect= new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth()+xCollisionOffset, sprite.getHeight()+yCollisionOffset);

        int lastDirection=direction;


        if(movingDown){
            lastDirection=2;
            collisionCheckRect.setY(sprite.getY()+speed);
        }
        if (movingLeft) {
            lastDirection=3;
            collisionCheckRect.setX(sprite.getX()-speed);
        }
        if (movingUp) {
            lastDirection=0;
            collisionCheckRect.setY(sprite.getY()-speed);
        }
        if(movingRight){
            lastDirection=1;
            collisionCheckRect.setX(sprite.getX()+speed);
        }
        if(lastDirection != direction){
            direction=lastDirection;
        }
        if(movingRight || movingLeft || movingDown ||movingUp){
            collisionCheckRect.setX(collisionCheckRect.getX()+xCollisionOffset);
            collisionCheckRect.setY(collisionCheckRect.getY()+yCollisionOffset);

            Rectangle axisCheckRect= new Rectangle(collisionCheckRect.getX(), collisionCheckRect.getY(),
                    collisionCheckRect.getWidth(), collisionCheckRect.getHeight());

            if(!renderer.getMap().checkCollision(axisCheckRect)){
                sprite.setX(collisionCheckRect.getX() -xCollisionOffset);
            }

            axisCheckRect.setX(sprite.getX()+xCollisionOffset);
            axisCheckRect.setY(collisionCheckRect.getY());
            axisCheckRect.setHeight(collisionCheckRect.getHeight());
            axisCheckRect.setWidth(collisionCheckRect.getWidth());

            if(!renderer.getMap().checkCollision(axisCheckRect)){
                sprite.setY(collisionCheckRect.getY()-yCollisionOffset);
            }
        }
    }

    public void setMovingUp(boolean moving){
        movingUp=moving;
        if(moving){
            sprite.setSprite(ImageLoader.getInstance().getMonsterUp());
        }
    }

    public void setMovingDown(boolean moving){
        movingDown = moving;
        if(moving){
            sprite.setSprite(ImageLoader.getInstance().getMonsterRight());
        }
    }

    public void setMovingLeft(boolean moving){
        movingLeft=moving;
        if(moving){
            sprite.setSprite(ImageLoader.getInstance().getMonsterLeft());
        }
    }

    public void setMovingRight(boolean moving){
        movingRight=moving;
        if(moving){
            sprite.setSprite(ImageLoader.getInstance().getMonsterRight());
        }
    }

    public boolean getMovingUp(){
        return movingUp;
    }

    public boolean getMovingRight(){
        return movingRight;
    }

    public boolean getMovingLeft(){
        return movingLeft;
    }

    public boolean getMovingDown(){
        return movingDown;
    }

    public Rectangle getSprite(){
        return sprite;
    }

    public int getDirection(){
        return direction;
    }



    /**
     * This method renders the player sprite based on its image and x, y position
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(sprite.getSprite(), sprite.getX(), sprite.getY(), null);
    }
}
