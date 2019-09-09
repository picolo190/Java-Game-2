package paoo.Game;

import paoo.Items.Rectangle;

import java.awt.*;
import java.util.ArrayList;

/**
 * The map class represents the map
 * it has 25x19 ints and every block is represented by a number from 0 to 5
 * 0-soil; 1- mountain; 2-water; 3-castle
 */
public class Map {

    private ArrayList<Tile> map= new ArrayList<>();

    public Map(){
        for(int x=0; x<Renderer.WIDTH/48; ++x) {
            map.add(new Tile(x*48, 0, 1, true));
            map.add(new Tile(x*48, (Renderer.HEIGHT/48-1)*48, 1, true));
        }
        for(int y=1; y<Renderer.HEIGHT/48; ++y) {
            map.add(new Tile(0, y*48, 1, true));
            map.add(new Tile((Renderer.WIDTH/48-1)*48, y*48, 1, true));
        }
        map.add(new Tile(48*10, 48*10, 2, true));
    }

    public Tile getTile(int x, int y){
        for(Tile tile: map){
            if(tile.getSprite().getX()==x && tile.getSprite().getY()==y){
                return tile;
            }
        }
        return null;
    }

    public boolean checkCollision(Rectangle rect){
        int currentX=rect.getX();
        int currentY=rect.getY();


        int blockXoffset= (currentX-48)%48;
        int blockX = currentX-48-blockXoffset;
        int blockYoffset= (currentY-48)%48;
        int blockY = currentY-48-blockYoffset;
        int maxBlockX=blockX+48*2;
        int maxBlockY=blockY+48*2;

        for(int x=blockX; x<=maxBlockX; x+=48){
            for(int y=blockY; y<=maxBlockY; y+=48){
                Tile tile= getTile(x,y);
                if(tile!=null) {
                    if (tile.getSprite().intersects(rect)) {
                        System.out.println(rect.getX()+" "+rect.getY());
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public ArrayList getMappedTiles(){
        return map;
    }

    public void render(Graphics g){

        for(int x=0;x<(Renderer.WIDTH/48)*48 ;x+=ImageLoader.getInstance().getGrass().getWidth(null)){
            for(int y=0;y<(Renderer.HEIGHT/48)*48 ;y+=ImageLoader.getInstance().getGrass().getHeight(null)){
                g.drawImage(ImageLoader.getInstance().getGrass(), x, y, null);
            }
        }
        for(int i=0; i<map.size();++i){
            Rectangle tempRect=map.get(i).getBlock();
            g.drawImage(tempRect.getSprite(), tempRect.getX(), tempRect.getY(), null);
        }
    }

}
