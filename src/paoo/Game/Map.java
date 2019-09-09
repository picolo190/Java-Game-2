package paoo.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 * The map class represents the map
 * it has 25x19 ints and every block is represented by a number from 0 to 5
 * 0-grass 1-mountain
 */
public class Map {

    private ArrayList<Tile> map= new ArrayList<>();
    private boolean renderedMap=false;

    public Map(){
        map.add(new Tile(0,0,1, true));
    }

    public void render(Graphics g){
        //Graphics graphics= renderer.getGraphics();
        for(int x=0;x<=Renderer.WIDTH;x+=ImageLoader.getInstance().getGrass().getWidth(null)){
            for(int y=0;y<=Renderer.HEIGHT; y+=ImageLoader.getInstance().getGrass().getHeight(null)){
                g.drawImage(ImageLoader.getInstance().getGrass(), x, y, null);
            }
        }
        for(int i=0; i<map.size();++i){
            switch (map.get(i).getId()){
                case 1:
                    g.drawImage(ImageLoader.getInstance().getSoil(), map.get(i).getX(), map.get(i).getY(), null);
            }
        }
        renderedMap=true;
    }

    public boolean checkRender(){
        return renderedMap;
    }


}
