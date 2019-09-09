package paoo.Entities;
import paoo.System.ImageLoader;
import paoo.System.Renderer;

import java.awt.*;
/**
 * Monster Class
 */
public class Monster implements GameObject {

    private int speed;
    private Rectangle sprite;
    private int monsterHealth;

    public Monster(int x, int y, int speed, int health) {
        sprite=new Rectangle(x, y,ImageLoader.getInstance().getMonsterLeft());
        this.speed=speed;
        monsterHealth=health;
    }


    @Override
    public void update(Renderer renderer){
        sprite.updateY(speed);
    }

    @Override
    public void render(Graphics g){
        g.drawImage(sprite.getSprite(), sprite.getX(), sprite.getY(), null);
    }
}
