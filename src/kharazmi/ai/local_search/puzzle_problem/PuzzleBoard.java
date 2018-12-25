package kharazmi.ai.local_search.puzzle_problem;

import java.util.ArrayList;

/**
 * Created by hosseyn on 12/24/2018.
 *
 * 0 number tile is empty tile
 */

public class PuzzleBoard {
    private ArrayList<Tile> tiles;

    public PuzzleBoard() {
        generateBoard();
    }

    private void generateBoard() {
        tiles = new ArrayList<Tile>();
    }

    public void printBoard() {
        tiles = new ArrayList<Tile>();
    }

}

