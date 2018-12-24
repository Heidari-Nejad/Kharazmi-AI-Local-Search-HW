package kharazmi.ai.local_search.queen_problem;

/**
 * Created by hosseyn on 12/24/2018.
 *
 */
public class Neighbour {
    private int row;
    private int column;
    private int value;

    public Neighbour(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val) {
        this.value = val;
    }

}
