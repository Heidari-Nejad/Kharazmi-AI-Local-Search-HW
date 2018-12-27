package kharazmi.ai.local_search.puzzle_problem;

import kharazmi.ai.local_search.Configurations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Integer> states = new ArrayList<>();
        for (int i = 0; i < Configurations.PUZZLE_PIECES; i++) states.add(i);
        Collections.shuffle(states);
        for(int i=0; i< Configurations.PUZZLE_PIECES; i++) {
            tiles.add(
                new Tile(
                        states.get(i),
                        i%Configurations.PUZZLE_SQUARE_SIDE,
                        i/Configurations.PUZZLE_SQUARE_SIDE
                )
            );
        }
    }

    public static ArrayList<Tile> getGoalTiles() {
        ArrayList<Tile> tiles = new ArrayList<Tile>();
        int[] states = {1, 2, 3, 8, 0, 4, 7, 6, 5};
        for(int i=0; i< Configurations.PUZZLE_PIECES; i++) {
            tiles.add(
                    new Tile(
                            states[i],
                            i%Configurations.PUZZLE_SQUARE_SIDE,
                            i/Configurations.PUZZLE_SQUARE_SIDE
                    )
            );
        }
        return tiles;
    }

    public static Tile getGoalTile(int state) {
        for(Tile tile: getGoalTiles())
            if(tile.getState() == state) return tile;

        return new Tile(0,0,0);
    }

    public Tile getTile(int state) {
        for(Tile tile: tiles)
            if(tile.getState() == state) return tile;

        return new Tile(-1,0,0);
    }

    public Tile getTile(int row, int col) {
        for(Tile tile: tiles)
            if(tile.getRow() == row && tile.getColumn() == col) return tile;

        return new Tile(-1,0,0);
    }

    public static void printBoardInline(ArrayList<Tile> tiles, int order) {
        System.out.println("$$$$$$$$$$$ Puzzle Board "+order+" $$$$$$$$$$$");
        for(int i = 0; i<Configurations.PUZZLE_PIECES; i++) {
            if(tiles == null) System.out.print(" ^ ");
            else if(tiles.get(i) == null) System.out.print(" ~ ");
            else if(tiles.get(i).getState() == 0) System.out.print(" - ");
            else System.out.print(" "+tiles.get(i).getRow()+":"+tiles.get(i).getColumn()+":"+tiles.get(i).getState()+" ");
        }
        System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    public static void printBoard(ArrayList<Tile> tiles, int order) {
        System.out.println("$$$$$$$$$$$ Puzzle Board "+order+" $$$$$$$$$$$");
        for(int row = 0; row<Configurations.PUZZLE_SQUARE_SIDE; row++) {
            for(int col = 0; col<Configurations.PUZZLE_SQUARE_SIDE; col++) {
                int key = col+row*Configurations.PUZZLE_SQUARE_SIDE;
                if (tiles.get(key).getState() == 0) System.out.print(" - ");
                else System.out.print(" " + tiles.get(key).getState() + " ");
            }
            System.out.print("\n");
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}

