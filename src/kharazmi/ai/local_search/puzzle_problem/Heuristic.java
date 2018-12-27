package kharazmi.ai.local_search.puzzle_problem;

import java.util.ArrayList;

/**
 * Created by hosseyn on 12/24/2018.
 *
 */
public class Heuristic {
    public static int manhatanDistance(ArrayList<Tile> tiles) {
        int distance = 0;
        for (Tile tile : tiles) {
            distance += Math.abs(tile.getColumn() - PuzzleBoard.getGoalTile(tile.getState()).getColumn());
            distance += Math.abs(tile.getRow() - PuzzleBoard.getGoalTile(tile.getState()).getRow());
        }
        return distance;
    }
}
