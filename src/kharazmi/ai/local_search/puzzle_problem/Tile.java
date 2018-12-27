package kharazmi.ai.local_search.puzzle_problem;

/**
 * Created by hosseyn on 12/24/2018.
 */
public class Tile {
    private int state;
    private int column;
    private int row;

    public Tile(int s) {
        this.state = s;
    }

    public Tile(int s, int col, int rw) {
        this.state = s;
        this.column = col;
        this.row = rw;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getState() {
        return state;
    }

    public void setState(int s) {
        this.state = s;
    }

}
