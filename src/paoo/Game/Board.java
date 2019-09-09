package paoo.Game;


import java.util.ArrayList;
import paoo.Items.*;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.*;

/**
 * Board class of the game
 **/
public class Board extends JPanel  {

    public ArrayList<GameObject> items = new ArrayList<>();
    private Monster monster;
    private boolean isRunning;

    public Board() {
        //Timer timer = new Timer(20, this);
        //timer.start();
        //initBoard();
    }

    /**
     * Initialize the board.

    private void initBoard() {
        addKeyListener(new MonsterKeyListener());
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Map.BOARD_WIDTH, Map.BOARD_HEIGHT));
        monster = new Monster(4 * 48, 4*48, 4);

        initBlocks();
        BoardUtility.loadBoardUtility(items, monster);
    }
     */
    /**
     * Initialize blocks according to the map.

    private void initBlocks() {
        int type;
        for (int x = 0; x < Map.level.length; x++) {
            for (int y = 0; y < Map.level[0].length; y++) {
                type = Map.level[x][y];
                BlockType bType = BlockType.getTypeFromInt(type);
                switch (bType) {
                    case TREE:
                        items.add(new Grass(y * 48, x * 48));
                        items.add(new Tree(y * 48, x * 48));
                        break;
                    case MOUNTAIN:
                        items.add(new Grass(y * 48, x * 48));
                        break;
                    case TOWN:
                        items.add(new Grass(y * 48, x * 48));
                        items.add(new Town(y * 48, x * 48));
                        break;
                    case GRASS:
                        items.add(new Grass(y * 48, x * 48));
                        break;
                    case SOIL:
                        items.add(new Soil(y * 48, x * 48));
                        break;
                    case WATER:
                        items.add(new Water(y * 48, x * 48));
                        break;
                    default:
                        break;
                }
            }
        }
    }
*/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawObjects(g);
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Draw objects on the board.

    private void drawObjects(Graphics g) {
        for (Item a : items) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }

        if (monster.isVisible()) {
            g.drawImage(monster.getImage(), monster.getX(), monster.getY(), this);
        }
        ArrayList<Rock> rocks = new ArrayList<>(monster.getRocks());

        for (Rock rock : rocks) {
            if (rock.isVisible()) {
                g.drawImage(rock.getImage(), rock.getX(), rock.getY(), this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateSprites();
    }

    private void updateSprites(){
        BoardUtility.updateMonster();
        BoardUtility.updateRocks();
    }

    private class MonsterKeyListener extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
            {
                isRunning=false;
            }
            else
            {
                monster.keyReleased(e);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            monster.keyPressed(e);
        }
    }
*/
}
