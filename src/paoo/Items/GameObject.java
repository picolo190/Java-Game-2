package paoo.Items;



import paoo.Game.Renderer;

import java.awt.*;


public interface GameObject {

    public void update(Renderer renderer);

    public void render(Graphics g);
}
