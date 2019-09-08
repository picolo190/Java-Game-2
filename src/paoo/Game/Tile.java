package paoo.Game;

public class Tile {
    private int x, y;
    private int id;
    private boolean collision;

    public Tile(int x, int y, int id, boolean collision){
        this.x=x;
        this.y=y;
        this.collision=collision;
        this.id=id;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getId(){
        return id;
    }
}
