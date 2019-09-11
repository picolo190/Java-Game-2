package paoo.Entities;
import paoo.System.Renderer;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet implements GameObject {

    private int speed;
    private Rectangle sprite;
    //direction: 0->right; 1->left; 2->down; 3->up
    private int direction;

    public Bullet(int x, int y, BufferedImage sprite, int speed, int direction) {
        this.sprite=new Rectangle(x,y,sprite);
        this.speed=speed;
        this.direction=direction;
    }

    public Rectangle getSprite(){
        return sprite;
    }

    @Override
    public void render(Graphics g){

        g.drawImage(sprite.getSprite(), sprite.getX(), sprite.getY(), null);
    }

    @Override
    public void update(Renderer renderer){
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

        for(int i=0; i<renderer.getObjects().size(); ++i){

            //Clearing the bullets which went out of the panel
            if(renderer.getObjects().get(i) instanceof Bullet)
            {
                int currentX=((Bullet) renderer.getObjects().get(i)).getSprite().getX();
                int currentY=((Bullet) renderer.getObjects().get(i)).getSprite().getY();
                if(currentX>Renderer.WIDTH || currentX<0){
                    renderer.getObjects().remove(renderer.getObjects().get(i));
                }
                if(currentY>Renderer.HEIGHT || currentY<0){
                    renderer.getObjects().remove(renderer.getObjects().get(i));
                }
            }

        }
    }
}
