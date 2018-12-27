package kharazmi.ai.local_search.puzzle_problem;

import kharazmi.ai.local_search.Configurations;
import kharazmi.ai.local_search.HillClimbing;
import kharazmi.ai.local_search.queen_problem.*;

import java.util.ArrayList;

/**
 * Created by hosseyn on 12/24/2018.
 *
 */
public class NPuzzleProblemSolver {
    public String solvable;
    private int order;
    private PuzzleBoard puzzle_board;

    static class Move {
        static final int UP = 0;
        static final int RIGHT = 1;
        static final int DOWN = 2;
        static final int LEFT = 3;
        static final int[] DIRECTIONS = {UP, RIGHT, DOWN, LEFT};
        static final String[] SIDES = {"UP", "RIGHT", "DOWN", "LEFT"};
    }

    public NPuzzleProblemSolver(PuzzleBoard board, int mOrder) {
        order = mOrder;
        solvable = Configurations.PROBLEM_SOLVING;
        puzzle_board = board;
        bestMoveResolver();
    }

    private void bestMoveResolver() {
        int current = Heuristic.manhatanDistance(puzzle_board.getTiles());
        if(current == 0) {
            solvable = Configurations.PROBLEM_SOLVED;
            return;
        }
        if (Configurations.TRACE_MODE) System.out.println(">> manhattan now: "+ current);
//        if (Configurations.TRACE_MODE) System.out.println(">> manhattan right: ");
        int best_neighbour = 100, neighbour = 100, best_move = -1;
        for(int move: Move.DIRECTIONS) {
            ArrayList<Tile> tempTiles = tempMover(move);
            if(tempTiles != null) neighbour = Heuristic.manhatanDistance(tempTiles);
            if(best_neighbour > neighbour) {
                best_neighbour = neighbour;
                best_move = move;
            }
        }
        if(current == best_neighbour)
            System.out.println(">> best neighbour is current!!!!!!!!!!!!!!");

        if(best_move >= 0 && current != best_neighbour && HillClimbing.steepestAscent(current, best_neighbour) == best_neighbour) {
            updateBoard(best_move);
            System.out.println(">> best move is <"+Move.SIDES[best_move]+"> by heuristic cost <"+best_neighbour+">");
            PuzzleBoard.printBoard(puzzle_board.getTiles(), order);
            System.out.println(" ");
        } else {
            System.out.println(">> problem not solved...");
            solvable = Configurations.PROBLEM_UNSOLVED;
        }

    }

    private ArrayList<Tile> tempMover(int move) {
        ArrayList<Tile> tempTiles = new ArrayList<>();
        Tile emptyTile = puzzle_board.getTile(0);
        Tile movableTile = new Tile(-1, 0, 0);
        switch (move) {
            case Move.UP: movableTile = puzzle_board.getTile(emptyTile.getRow()-1, emptyTile.getColumn()); break;
            case Move.RIGHT: movableTile = puzzle_board.getTile(emptyTile.getRow(), emptyTile.getColumn()+1); break;
            case Move.DOWN: movableTile = puzzle_board.getTile(emptyTile.getRow()+1, emptyTile.getColumn()); break;
            case Move.LEFT: movableTile = puzzle_board.getTile(emptyTile.getRow(), emptyTile.getColumn()-1); break;
        }
        // determine valid move...
        if(movableTile.getState() >= 0 && movableTile.getRow() >= 0 && movableTile.getColumn() >= 0) {
            // submit move on temp tiles
            for(Tile tile: puzzle_board.getTiles()) {
                if(movableTile.getState() == tile.getState()) tempTiles.add(new Tile(0, tile.getColumn(), tile.getRow()));
                else if(tile.getState() == 0) tempTiles.add(new Tile(movableTile.getState(), tile.getColumn(), tile.getRow()));
                else tempTiles.add(new Tile(tile.getState(), tile.getColumn(), tile.getRow()));
            }
            return tempTiles;
        }
        return null;
    }

    private void updateBoard(int move) {
        for(Tile tempTile: tempMover(move)) {
            for(Tile tile: puzzle_board.getTiles()) {
                if(tile.getColumn() == tempTile.getColumn() && tile.getRow() == tempTile.getRow())
                    tile.setState(tempTile.getState());
            }
        }
        System.out.println(">> board updated!!!!!");

    }

    public PuzzleBoard getPuzzleBoard() {
        return puzzle_board;
    }
}
