package kharazmi.ai.local_search.puzzle_problem;

/**
 * Created by hosseyn on 12/24/2018.
 */
public class Tile {
    private int state;

    public Tile(int s) {
        this.state = s;
    }

    public int getState() {
        return state;
    }

    public void setState(int s) {
        this.state = s;
    }

}
