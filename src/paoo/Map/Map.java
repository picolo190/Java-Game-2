package paoo.Map;

import paoo.Entities.Rectangle;
import paoo.System.ImageLoader;
import paoo.System.Renderer;

import java.awt.*;
import java.util.ArrayList;

/**
 * The map class represents the map
 * it has 25x19 ints and every block is represented by a number from 0 to 5
 * 0-soil; 1- mountain; 2-water; 3-castle; 4- tree; 5- TNT
 */
public class Map {

    //The mapped Tiles in the map
    private ArrayList<Tile> map1= new ArrayList<>();
    private ArrayList<Tile> map2 = new ArrayList<>();
    private ArrayList<Tile> map3 = new ArrayList<>();

    /**
     * The Map class constructor
     */
    public Map(){

        //First the map gets filled with the border
        for(int x = 0; x< Renderer.WIDTH/48; ++x) {
            map1.add(new Tile(x*48, 0, 1, true));
            map1.add(new Tile(x*48, (Renderer.HEIGHT/48-1)*48, 1, true));
            map2.add(new Tile(x*48, 0, 1, true));
            map2.add(new Tile(x*48, (Renderer.HEIGHT/48-1)*48, 1, true));
            map3.add(new Tile(x*48, 0, 1, true));
            map3.add(new Tile(x*48, (Renderer.HEIGHT/48-1)*48, 1, true));

        }
        for(int y=1; y<Renderer.HEIGHT/48; ++y) {
            map1.add(new Tile(0, y*48, 1, true));
            map1.add(new Tile((Renderer.WIDTH/48-1)*48, y*48, 1, true));
            map2.add(new Tile(0, y*48, 1, true));
            map2.add(new Tile((Renderer.WIDTH/48-1)*48, y*48, 1, true));
            map3.add(new Tile(0, y*48, 1, true));
            map3.add(new Tile((Renderer.WIDTH/48-1)*48, y*48, 1, true));
        }

        //Now we fill the map however we want
        map1.add(new Tile(48*10, 48*10, 2, true));
        map1.add(new Tile(48*11, 48*10, 3,true));

        //Map for level 2
        map2.add(new Tile(48*10, 48*10,2,true));
        map2.add(new Tile(48*10, 48*11,2,true));
        map2.add(new Tile(48*11, 48*10,2,true));
        map2.add(new Tile(48*11, 48*11,2,true));
        map2.add(new Tile(48*12, 48*10,2,true));
        map2.add(new Tile(48*12, 48*11,2,true));
        map2.add(new Tile(48*20, 48*5, 3,true));
        map2.add(new Tile(48*20, 48*7, 0,true));
        map2.add(new Tile(48*21, 48*7, 0,true));
        map2.add(new Tile(48*22, 48*7, 0,true));
        map2.add(new Tile(48*22, 48*6, 0,true));
        map2.add(new Tile(48*23, 48*6, 0,true));
        map2.add(new Tile(48*23, 48*7, 0,true));


        map2.add(new Tile(48*8, 48*4, 1,true));
        map2.add(new Tile(48*9, 48*4, 1,true));
        map2.add(new Tile(48*8, 48*5, 1,true));

        map2.add(new Tile(48*17, 48*11, 1,true));
        map2.add(new Tile(48*18, 48*11, 1,true));
        map2.add(new Tile(48*19, 48*12, 1,true));

        //Map for level 3
        map3.add(new Tile(48*1, 48*5, 3, true));

        map3.add(new Tile(48*1, 48*7, 1 ,true));
        map3.add(new Tile(48*2, 48*7, 1 ,true));
        map3.add(new Tile(48*3, 48*7, 1 ,true));
        map3.add(new Tile(48*3, 48*4, 1 ,true));
        map3.add(new Tile(48*2, 48*4, 1 ,true));
        map3.add(new Tile(48*1, 48*4, 1 ,true));


        for (int i = 9 ; i < 17; i++)
        {
            for(int j = 10 ; j < 14; j++)
            {
                if( i == 9 || i == 16)
                {
                    if(j % 2 == 0) {
                        map3.add(new Tile(48 * i, 48 * j, 4, true));
                    }
                    else {
                        map3.add(new Tile(48*i, 48*j,5,true));
                    }
                }
                else {
                    map3.add(new Tile(48 * i, 48 * j, 2, true));
                }
            }
        }

        map3.add(new Tile(48*9, 48*10, 4 ,true));



    }

    /**
     * Getter method for the mapped tiles
     * @param x = the x position of the mapped tile; int
     * @param y = the y position of the mapped tile; int
     * @return this method returns a tile; Tile
     */
    public Tile getTile(int x, int y, int level){
        if (level ==1)
        {
            for (Tile tile : map1) {
                if (tile.getSprite().getX() == x && tile.getSprite().getY() == y) {
                    return tile;
                }
            }
        }
        else if (level == 2)
        {
            for (Tile tile : map2) {
                if (tile.getSprite().getX() == x && tile.getSprite().getY() == y) {
                    return tile;
                }
            }
        }
        else if (level == 3)
        {
            for (Tile tile : map3) {
                if (tile.getSprite().getX() == x && tile.getSprite().getY() == y) {
                    return tile;
                }
            }
        }
        return null;
    }

    /**
     * This method checks if there are any collisions within one tile radius from the player position
     * @param rect = usually the player of the entity that has it's own behaviour
     * @return = true if it collides, false if it doesn't; boolean
     */
    public boolean checkCollision(Rectangle rect, int level){
        int currentX=rect.getX();
        int currentY=rect.getY();


        int blockXoffset= (currentX-48)%48;
        int blockX = currentX-48-blockXoffset;
        int blockYoffset= (currentY-48)%48;
        int blockY = currentY-48-blockYoffset;
        int maxBlockX=blockX+48*2;
        int maxBlockY=blockY+48*2;

        //iterating through all the blocks that surrounds the player
        for(int x=blockX; x<=maxBlockX; x+=48){
            for(int y=blockY; y<=maxBlockY; y+=48){
                Tile tile= getTile(x,y,level);
                if(tile!=null) {
                    if (tile.getSprite().intersects(rect)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    /**
     * Getter method for the mapped tiles
     * @return the arraylist of mapped tiles
     */
    public ArrayList getMappedTiles(int level){
        if (level == 1)
        {
            return map1;
        }
        else if (level == 2){
            return map2;
        }
        return map3;
    }

    /**
     * This method renders the tiles of the map
     * @param g the view on which tiles will be rendered
     * @param level the level the player is at
     */
    public void render(Graphics g, int level){
        //filling the map with grass or dirt
        if(level == 3){
            for(int x=0;x<(Renderer.WIDTH/48)*48 ;x+= ImageLoader.getInstance().getSoil().getWidth(null)){
                for(int y=0;y<(Renderer.HEIGHT/48)*48 ;y+=ImageLoader.getInstance().getSoil().getHeight(null)){
                    g.drawImage(ImageLoader.getInstance().getSoil(), x, y, null);
                }
            }
        }
        else {
            for (int x = 0; x < (Renderer.WIDTH / 48) * 48; x += ImageLoader.getInstance().getGrass().getWidth(null)) {
                for (int y = 0; y < (Renderer.HEIGHT / 48) * 48; y += ImageLoader.getInstance().getGrass().getHeight(null)) {
                    g.drawImage(ImageLoader.getInstance().getGrass(), x, y, null);
                }
            }
        }
        //iterating through all the mapped blocks
        if (level == 1) {
            for (int i = 0; i < map1.size(); ++i) {
                Rectangle tempRect = map1.get(i).getSprite();
                g.drawImage(tempRect.getSprite(), tempRect.getX(), tempRect.getY(), null);
            }
        }
        else if (level == 2){
            for (int i = 0; i < map2.size(); ++i) {
                Rectangle tempRect = map2.get(i).getSprite();
                g.drawImage(tempRect.getSprite(), tempRect.getX(), tempRect.getY(), null);
            }
        }
        else{
            for (int i = 0; i < map3.size(); ++i) {
                Rectangle tempRect = map3.get(i).getSprite();
                g.drawImage(tempRect.getSprite(), tempRect.getX(), tempRect.getY(), null);
            }
        }
    }

}
