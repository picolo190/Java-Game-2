package paoo.System;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


/**
 * ImageLoader represents a singleton, used to get all the sprites at once and just get them in the memory
 * using this method, we avoid loading the same images every time we update the panel
 */
public class ImageLoader {
    private final BufferedImage highScoreBackground;
    private final BufferedImage water;
    private final BufferedImage grass;
    private final BufferedImage monsterLeft;
    private final BufferedImage monsterRight;
    private final BufferedImage monsterDown;
    private final BufferedImage zeldaUp;
    private final BufferedImage zeldaLeft;
    private final BufferedImage zeldaDown;
    private final BufferedImage zeldaRight;
    private final BufferedImage enemy;
    private final BufferedImage mountain;
    private final BufferedImage rockDown;
    private final BufferedImage rockLeft;
    private final BufferedImage rockRight;
    private final BufferedImage rockUp;
    private final BufferedImage soil;
    private final BufferedImage town;
    private final BufferedImage townGrassDestroyed;
    private final BufferedImage monsterUp;
    private final BufferedImage tree;
    private final BufferedImage tnt;
    private static ImageLoader instance=null;

    public static ImageLoader getInstance(){
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    /**
     * The constructor which loads every image
     */
    private ImageLoader() {
        this.water = loadImage("images/water.png");
        this.enemy = loadImage("images/random.png");
        this.grass = loadImage("images/grass.png");
        //this.grass = loadImage("images/cem.png");
        this.monsterLeft = loadImage("images/trumpLeft.png");
        this.monsterRight = loadImage("images/trumpRight.png");
        this.monsterDown = loadImage("images/trumpDown.png");
        this.zeldaLeft = loadImage("images/zeldaLeft.png");
        this.zeldaUp = loadImage("images/zeldaUp.png");
        this.zeldaRight = loadImage("images/zeldaRight.png");
        this.zeldaDown = loadImage("images/zeldaUp.png");
        this.mountain = loadImage("images/mountain.png");
        this.rockDown = loadImage("images/rockDown.png");
        this.rockLeft = loadImage("images/rockLeft.png");
        this.rockRight = loadImage("images/rockRight.png");
        this.rockUp = loadImage("images/rockUp.png");
        this.soil = loadImage("images/Dirt.PNG");
        //this.town = loadImage("images/townGrass.png");
        this.town = loadImage("images/castle.png");
        this.townGrassDestroyed = loadImage("images/townGrassDestroyed.png");
        this.tree = loadImage("images/tree.png");
        this.monsterUp=loadImage("images/trumpUp.png");
        this.tnt = loadImage("images/Tnt.PNG");
        this.highScoreBackground=loadImage("images/imagine.jpg");
    }

    public BufferedImage loadImage(String imageAddress) {
        try {
            BufferedImage icon = ImageIO.read(new File(imageAddress));
            BufferedImage formattedIcon = new BufferedImage(icon.getWidth(), icon.getHeight(), BufferedImage.TYPE_INT_ARGB);
            formattedIcon.getGraphics().drawImage(icon, 0,0,null);
            return formattedIcon;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    /**
     * getter functions so we can get whatever image we need
     */
    public BufferedImage getHighScoreBackground(){return highScoreBackground;}
    public BufferedImage getWater(){ return water;}
    public BufferedImage getGrass(){ return grass;}
    public BufferedImage getMonsterLeft(){
        if(HelpMenu.selectedSprite ==0){
        return monsterLeft;
        }
        else
            return zeldaLeft;
    }
    public BufferedImage getMonsterRight(){
        if(HelpMenu.selectedSprite ==0) {
            return monsterRight;
        }
        else
            return zeldaRight;
    }
    public BufferedImage getMonsterDown(){
        if(HelpMenu.selectedSprite ==0 ) {
            return monsterDown;
        }
        else
            return zeldaDown;
    }
    public BufferedImage getEnemy(){ return enemy;}
    public BufferedImage getMountain(){ return mountain;}
    public BufferedImage getRockDown(){ return rockDown;}
    public BufferedImage getRockLeft(){ return rockLeft;}
    public BufferedImage getRockRight(){ return rockRight;}
    public BufferedImage getRockUp(){ return rockUp;}
    public BufferedImage getSoil(){ return soil;}
    public BufferedImage getTown(){ return town;}
    public BufferedImage getTownGrassDestroyed(){ return townGrassDestroyed;}
    public BufferedImage getMonsterUp(){
        if(HelpMenu.selectedSprite == 0) {
            return monsterUp;
        }
        else
            return zeldaUp;
    }
    public BufferedImage getTree(){ return tree;}
    public BufferedImage getTNT() { return tnt;}
    public BufferedImage getZeldaLeft(){ return zeldaLeft;}
    public BufferedImage getZeldaUp(){ return zeldaUp;}
    public BufferedImage getZeldaDown(){ return zeldaDown;}
    public BufferedImage getZeldaRight(){ return zeldaRight;}

}
