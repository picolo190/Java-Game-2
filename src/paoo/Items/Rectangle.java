package paoo.Items;

import java.awt.*;

/**
 * The Rectangle method defines the game objects appearance: the actual sprite(Image) and the x, y positions on the jpanel
 */
public class Rectangle {
    private Image sprite;
    private int x,y, width, height;

    public Rectangle(int x, int y, Image sprite){
        this.x = x;
        this.y=y;
        this.sprite=sprite;
        width=sprite.getWidth(null);
        height=sprite.getHeight(null);
    }

    public void updateX(int xx){
        x+=xx;
    }

    public void updateY(int yy){
        y+=yy;
    }

    /**
     * This method checks for 2 rectangles intersection
     * @param anotherRec= another rectangle we want to check collision with
     * @return= the method returns true or false, if there is a collision within those rectangles
     */
    public boolean intersects(Rectangle anotherRec){
        if(x > anotherRec.getX() + anotherRec.getSprite().getWidth(null) || anotherRec.getX() > x + width)
            return false;
        if(y > anotherRec.getY() + anotherRec.getSprite().getHeight(null) || anotherRec.getY() > y + height)
            return false;
        return true;
    }

    public Image getSprite(){
        return sprite;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
