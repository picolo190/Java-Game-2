package paoo.Items;

import java.awt.*;

public class Bullet implements GameObject {

    private int speed;
    private Rectangle sprite;
    private int direction;

    public Bullet(int x, int y, Image sprite, int speed, int direction) {
        this.sprite=new Rectangle(x,y,sprite);
        this.speed=speed;
        this.direction=direction;
    }

    @Override
    public void render(){

    }

    @Override
    public void update(){
        switch (direction){
            case 0:
                sprite.updateX(speed);
                break;
            case 1:
                sprite.updateX(speed*(-1));
                break;
            case 2:
                sprite.updateY(speed);
                break;
            case 3:
                sprite.updateY(speed*(-1));
                break;
        }
    }
}
