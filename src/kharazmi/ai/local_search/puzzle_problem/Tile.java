package kharazmi.ai.local_search.puzzle_problem;

/**
 * Created by hosseyn on 12/24/2018.
 */
public class Tile {
    private int row;
    private int column;
    private int number;

    public Tile(int row, int column, int num) {
        this.row = row;
        this.column = column;
        this.number = num;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int rw) {
        this.row = rw;
    }

    public int getColumn() {
        return column;
    }

}
