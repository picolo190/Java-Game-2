package paoo;

import paoo.Game.Map;
import paoo.Game.Renderer;

public class Main {


    public static void main(String[] args) throws Exception{
	    Renderer renderer = new Renderer();
        Map map= new Map();
        map.render(renderer);
        while(true){
            map.render(renderer);
        }
        //Board panel = new Board();
        /**
        theView.getPanel().add(panel);
        panel.requestFocusInWindow();
        panel.setIsRunning(true);
        theView.setVisible(true);
        while(panel.getIsRunning()){
            panel.revalidate();
            panel.repaint();
        }
**/
        //theView.remove(panel);
        //theView.setVisible(false);

    }
}
