package paoo.System;


import paoo.System.Renderer;

import javax.swing.*;
import java.awt.*;

public class Main {


    public static void main(String[] args){
        JFrame window = new JFrame();

        //this tells the game to close when the close button of the window is pressed; it can be called a handler
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Game");
        window.setPreferredSize(new Dimension(Renderer.WIDTH, Renderer.HEIGHT));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(true);

        //Creating the JPanel on which we draw
	    Renderer renderer = new Renderer();
	    window.add(renderer);
	    renderer.requestFocusInWindow();

	    //Creating the game loop
        long lastTime = System.nanoTime(); //long 2^63
        double nanoSecondConversion = 1000000000.0 / 60; //60 frames per second
        double changeInSeconds = 0;


        while(true)
        {
            long now = System.nanoTime();

            changeInSeconds += (now - lastTime) / nanoSecondConversion;
            while(changeInSeconds >= 1) {
                renderer.update();
                changeInSeconds--;
            }

            renderer.revalidate();
            renderer.repaint();
            lastTime = now;
        }


    }
}
