package kharazmi.ai.local_search.puzzle_problem;

import kharazmi.ai.local_search.Configurations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
            tiles.add(new Tile(states.get(i)));
        }
    }

    public void printBoardInline(int order) {
        System.out.println("$$$$$$$$$$$ Puzzle Board "+order+" $$$$$$$$$$$");
        for(int i = 0; i<Configurations.PUZZLE_PIECES; i++) {
            if(tiles.get(i).getState() == 0) System.out.print(" - ");
            else System.out.print(" "+tiles.get(i).getState()+" ");
        }
        System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    public void printBoard(int order) {
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
}

