package paoo.Map;

import paoo.Entities.Rectangle;
import paoo.System.ImageLoader;
import paoo.System.Renderer;

import java.awt.*;
import java.util.ArrayList;

/**
 * The map class represents the map
 * it has 25x19 ints and every block is represented by a number from 0 to 5
 * 0-soil; 1- mountain; 2-water; 3-castle
 */
public class Map {

    //The mapped Tiles in the map
    private ArrayList<Tile> map= new ArrayList<>();

    /**
     * The Map class constructor
     */
    public Map(){

        //First the map gets filled with the border
        for(int x = 0; x< Renderer.WIDTH/48; ++x) {
            map.add(new Tile(x*48, 0, 1, true));
            map.add(new Tile(x*48, (Renderer.HEIGHT/48-1)*48, 1, true));
        }
        for(int y=1; y<Renderer.HEIGHT/48; ++y) {
            map.add(new Tile(0, y*48, 1, true));
            map.add(new Tile((Renderer.WIDTH/48-1)*48, y*48, 1, true));
        }

        //Now we fill the map however we want
        map.add(new Tile(48*10, 48*10, 2, true));
        map.add(new Tile(48*11, 48*10, 3,true));

    }

    /**
     * Getter method for the mapped tiles
     * @param x = the x position of the mapped tile; int
     * @param y = the y position of the mapped tile; int
     * @return this method returns a tile; Tile
     */
    public Tile getTile(int x, int y){
        for(Tile tile: map){
            if(tile.getSprite().getX()==x && tile.getSprite().getY()==y){
                return tile;
            }
        }
        return null;
    }

    /**
     * This method checks if there are any collisions within one tile radius from the player position
     * @param rect = usually the player of the entity that has it's own behaviour
     * @return = true if it collides, false if it doesn't; boolean
     */
    public boolean checkCollision(Rectangle rect){
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
                Tile tile= getTile(x,y);
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
    public ArrayList getMappedTiles(){
        return map;
    }

    /**
     * This method renders the tiles of the map
     * @param g the view on which tiles will be rendered
     */
    public void render(Graphics g){
        //filling the map with grass
        for(int x=0;x<(Renderer.WIDTH/48)*48 ;x+= ImageLoader.getInstance().getGrass().getWidth(null)){
            for(int y=0;y<(Renderer.HEIGHT/48)*48 ;y+=ImageLoader.getInstance().getGrass().getHeight(null)){
                g.drawImage(ImageLoader.getInstance().getGrass(), x, y, null);
            }
        }

        //iterating through all the mapped blocks
        for(int i=0; i<map.size();++i){
            Rectangle tempRect=map.get(i).getSprite();
            g.drawImage(tempRect.getSprite(), tempRect.getX(), tempRect.getY(), null);
        }
    }

}
