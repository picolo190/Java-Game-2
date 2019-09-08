package paoo.Items;
import paoo.Game.ImageLoader;

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
    public void update(){
        sprite.updateY(speed);
    }

    @Override
    public void render(){

    }
}
