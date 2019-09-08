package paoo.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * The map class represents the map
 * it has 25x19 ints and every block is represented by a number from 0 to 5
 * 0-grass 1-mountain
 */
public class Map {

    private ArrayList<Tile> map= new ArrayList<Tile>();

    public Map(){
        map.add(new Tile(10,40,1, true));
    }

    public void render(Renderer renderer){
        Graphics graphics= renderer.getGraphics();
        for(int x=ImageLoader.getInstance().getGrass().getWidth(null);x<=renderer.WIDTH/2;x+=ImageLoader.getInstance().getGrass().getWidth(null)){
            for(int y=ImageLoader.getInstance().getGrass().getWidth(null);y<=renderer.HEIGHT/2; y+=ImageLoader.getInstance().getGrass().getHeight(null)){
                graphics.drawImage(ImageLoader.getInstance().getGrass(), x, y, renderer);
            }
        }
        for(int i=0; i<map.size();++i){
            switch (map.get(i).getId()){
                case 1:
                    graphics.drawImage(ImageLoader.getInstance().getSoil(), map.get(i).getX(), map.get(i).getY(), renderer);
            }
        }
    }



}
