package paoo.Items;

import java.awt.image.BufferedImage;

/**
 * The Rectangle method defines the game objects appearance: the actual sprite(BufferedImage) and the x, y positions on the jpanel
 */
public class Rectangle {
    private BufferedImage sprite;
    private int x,y, width, height;

    public Rectangle(int x, int y, BufferedImage sprite){
        this.x = x;
        this.y=y;
        this.sprite=sprite;
        width=sprite.getWidth(null);
        height=sprite.getHeight(null);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
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

    public void setSprite(BufferedImage image){sprite=image;}

    public BufferedImage getSprite(){
        return sprite;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
