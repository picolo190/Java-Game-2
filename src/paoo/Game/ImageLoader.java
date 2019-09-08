package paoo.Game;

import javax.swing.*;
import java.awt.*;


/**
 * ImageLoader represents a singleton, used to get all the sprites at once and just get them in the memory
 * using this method, we avoid loading the same images every time we update the panel
 */
public class ImageLoader {
    private final Image water;
    private final Image grass;
    private final Image monsterLeft;
    private final Image monsterRight;
    private final Image mountain;
    private final Image rockDown;
    private final Image rockLeft;
    private final Image rockRight;
    private final Image rockUp;
    private final Image soil;
    private final Image townGrass;
    private final Image townGrassDestroyed;
    private final Image townSoil;
    private final Image monsterUp;
    private final Image tree;
    private static ImageLoader instance=null;

    public static ImageLoader getInstance(){
        if( instance != null){
            return instance;
        }
        else{
            instance=new ImageLoader();
            return instance;
        }
    }

    /**
     * The constructor which loads every image
     */
    private ImageLoader() {
        this.water = loadImage("images/water.png");
        this.grass = loadImage("images/grass.png");
        this.monsterLeft = loadImage("images/monsterLeft.png");
        this.monsterRight = loadImage("images/monsterRight.png");
        this.mountain = loadImage("images/mountain.png");
        this.rockDown = loadImage("images/rockDown.png");
        this.rockLeft = loadImage("images/rockLeft.png");
        this.rockRight = loadImage("images/rockRight.png");
        this.rockUp = loadImage("images/rockUp.png");
        this.soil = loadImage("images/soil.png");
        this.townGrass = loadImage("images/townGrass.png");
        this.townGrassDestroyed = loadImage("images/townGrassDestroyed.png");
        this.townSoil = loadImage("images/townSoil.png");
        this.tree = loadImage("images/tree.png");
        this.monsterUp=loadImage("images/monsterUp.png");
    }

    public Image loadImage(String imageAddress) {
        ImageIcon icon = new ImageIcon(imageAddress);
        return icon.getImage();
    }

    /**
     * getter functions so we can get whatever image we need
     */
    public Image getWater(){ return water;}
    public Image getGrass(){ return grass;}
    public Image getMonsterLeft(){ return monsterLeft;}
    public Image getMonsterRight(){ return monsterRight;}
    public Image getMountain(){ return mountain;}
    public Image getRockDown(){ return rockDown;}
    public Image getRockLeft(){ return rockLeft;}
    public Image getRockRight(){ return rockRight;}
    public Image getRockUp(){ return rockUp;}
    public Image getSoil(){ return soil;}
    public Image getGRass(){ return townGrass;}
    public Image getGrassDestryed(){ return townGrassDestroyed;}
    public Image getMonsterUp(){return monsterUp;}
    public Image getTownSoil(){ return townSoil;}
    public Image getTree(){ return tree;}

}
