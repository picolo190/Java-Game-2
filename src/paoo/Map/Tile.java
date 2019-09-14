package paoo.Map;

import paoo.Entities.Rectangle;
import paoo.System.ImageLoader;

public class Tile {
    private int id;
    public Rectangle sprite;
    private boolean collision;
    //0-soil; 1- mountain; 2-water; 3-castle


    /**
     * The Tile class constructor
     * @param x = the x position; int field
     * @param y = the y position; int field
     * @param id =the id of the tile; int field
     * @param collision = boolean field which shows if the tile is collideable
     */
    public Tile(int x, int y, int id, boolean collision){
        switch (id){
            case 0:
                sprite=new Rectangle(x,y, ImageLoader.getInstance().getSoil());
                break;
            case 1:
                sprite=new Rectangle(x,y,ImageLoader.getInstance().getMountain());
                break;
            case 2:
                sprite= new Rectangle(x,y,ImageLoader.getInstance().getWater());
                break;
            case 3:
                sprite= new Rectangle(x,y, ImageLoader.getInstance().getTown());
                break;
            case 4:
                sprite = new Rectangle(x,y,ImageLoader.getInstance().getTree());
                break;
            case 5:
                sprite = new Rectangle(x,y,ImageLoader.getInstance().getTNT());
                break;
            default:
                sprite= new Rectangle(x,y,ImageLoader.getInstance().getGrass());
                break;
        }
        this.collision=collision;
        this.id=id;
    }

    /**
     * This method checks if the tile is collideable or not
     * @return the collision field
     */
    public boolean isCollision(){
        return collision;
    }

    /**
     * Setter method for the sprite field
     * @param sprite = the new sprite to be set; Rectangle output
     */
    public void setSprite(Rectangle sprite){
        this.sprite=sprite;
    }

    /**
     * Getter method for the sprite field
     * @return the sprite field; returns a Rectangle
     */
    public Rectangle getSprite(){
        return sprite;
    }

    public int getId(){
        return id;
    }
}
