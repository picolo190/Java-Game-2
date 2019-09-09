package paoo.Map;

import paoo.Entities.Rectangle;
import paoo.System.ImageLoader;

public class Tile {
    private int id;
    public Rectangle sprite;
    private boolean collision;
    //0-soil; 1- mountain; 2-water; 3-castle


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
            default:
                sprite= new Rectangle(x,y,ImageLoader.getInstance().getGrass());
                break;
        }
        this.collision=collision;
        this.id=id;
    }

    public boolean isCollision(){
        return collision;
    }

    public void setSprite(Rectangle sprite){
        this.sprite=sprite;
    }

    public Rectangle getSprite(){
        return sprite;
    }

    public Rectangle getBlock(){
        return sprite;
    }

    public int getId(){
        return id;
    }
}
