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
    private long timeElapsed=0;

    public Monster(int x, int y, int speed, int health) {
        sprite=new Rectangle(x, y,ImageLoader.getInstance().getMonsterLeft());
        this.speed=speed;
        monsterHealth=health;
        timeElapsed=System.currentTimeMillis();
    }


    public int getMonsterHealth(){
        return monsterHealth;
    }

    public Rectangle getSprite(){
        return sprite;
    }

    @Override
    public void update(Renderer renderer){
        if(sprite.intersects(renderer.getPlayer().getSprite())){
            if(System.currentTimeMillis()-timeElapsed>=1000) {
                timeElapsed=System.currentTimeMillis();
                renderer.getPlayer().setPlayerHealth(renderer.getPlayer().getPlayerHealth() - 1);
            }
        }

        if(renderer.getPlayer().getSprite().getX()>sprite.getX()){
            sprite.updateX(speed);
        }
        if(renderer.getPlayer().getSprite().getX()<sprite.getX()){
            sprite.updateX(-speed);
        }
        if(renderer.getPlayer().getSprite().getY()>sprite.getY()){
            sprite.updateY(speed);
        }
        if(renderer.getPlayer().getSprite().getY()<sprite.getY()){
            sprite.updateY(-speed);
        }

        for(int i=0; i<renderer.getObjects().size();++i){
            if(renderer.getObjects().get(i) instanceof Monster){
                if(((Monster) renderer.getObjects().get(i)).getMonsterHealth()==0){
                    renderer.setScore(renderer.getScore()+1);
                    renderer.getObjects().remove(renderer.getObjects().get(i));
                }
            }
            if(i<renderer.getObjects().size()) {
                if (renderer.getObjects().get(i) instanceof Bullet) {
                    if (((Bullet) renderer.getObjects().get(i)).getSprite().intersects(sprite)) {
                        monsterHealth--;
                        renderer.getObjects().remove(renderer.getObjects().get(i));
                    }
                }
            }
        }

    }

    @Override
    public void render(Graphics g){
        g.drawImage(sprite.getSprite(), sprite.getX(), sprite.getY(), null);
    }
}
