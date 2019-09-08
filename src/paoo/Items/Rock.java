package paoo.Items;

import paoo.Game.ImageLoader;
import paoo.Game.Map;

public class Rock implements GameObject {
    private int speed;
    private int direction;

    private Rectangle sprite;

    public Rock(int x, int y, Rectangle sprite) {
        this.sprite=new Rectangle(x,y, sprite.getSprite());

    }

    @Override
    public void update(){

    }

    @Override
    public void render(){

    }

}
