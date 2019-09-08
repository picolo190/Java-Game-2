package paoo.Game;

import paoo.Items.GameObject;
import paoo.Items.Monster;

import java.util.ArrayList;

/**
 * not a useful class; this should be implemented as a update function in every gameobject
 * so it respects the SOLID principles
 */
public class BoardUtility {
    private static ArrayList<GameObject> items = new ArrayList<>();
    private static Monster monster;

    static void loadBoardUtility(ArrayList<GameObject> _items, Monster _monster) {
        items = _items;
        monster = _monster;
    }



}
