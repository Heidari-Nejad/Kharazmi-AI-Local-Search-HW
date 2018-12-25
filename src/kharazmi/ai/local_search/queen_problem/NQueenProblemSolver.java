package kharazmi.ai.local_search.queen_problem;

import kharazmi.ai.local_search.Configurations;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by hosseyn on 12/24/2018.
 *
 */
public class NQueenProblemSolver {
    private Neighbour[] neighbours;
    private ChessBoard chess_board;
    private ArrayList<Neighbour> best_neighbours;

    public NQueenProblemSolver(ChessBoard board) {
        chess_board = board;
        generateNeighbours();
        neighbourValueComputing();
        bestNeighboursResolver();
        updateChessBoard();
    }
    public void generateNeighbours() {
        neighbours = new Neighbour[Configurations.CHESS_NEIGHBOURS];
        int h = 0;
        for(int i=0; i<Configurations.CHESS_SIZE; i++){
            int queen_row = chess_board.getQueens()[i].getRow();
            for(int j=0; j<Configurations.CHESS_SIZE; j++){
                if(j != queen_row) {
                    neighbours[h++] = new Neighbour(j, i);
                }
            }
        }
    }

    public void neighbourValueComputing() {
        for(int i=0; i<Configurations.CHESS_NEIGHBOURS; i++){
            Queen[] tempQueens = new Queen[Configurations.CHESS_NEIGHBOURS];
            for (int j=0; j<Configurations.CHESS_SIZE; j++) {
                tempQueens[j] = new Queen(chess_board.getQueens()[j].getRow(),
                        chess_board.getQueens()[j].getColumn());
            }
            tempQueens[neighbours[i].getColumn()].setRow(neighbours[i].getRow());
            neighbours[i].setValue(Heuristic.attackingPairs(tempQueens));
        }
    }

    public void bestNeighboursResolver() {
        best_neighbours = new ArrayList<>();
        int best_value = Configurations.CHESS_NEIGHBOURS;
        for(int i=0; i<Configurations.CHESS_NEIGHBOURS; i++){
            if(best_value > neighbours[i].getValue()) {
                best_value = neighbours[i].getValue();
            }
        }
//        System.out.println(" best value: "+best_value);
        for(int i=0; i<Configurations.CHESS_NEIGHBOURS; i++){
            if(best_value == neighbours[i].getValue()) {
                best_neighbours.add(new Neighbour(neighbours[i].getRow(), neighbours[i].getColumn()));
            }
        }
    }

    public void updateChessBoard() {
        Neighbour rand_best = best_neighbours.get(new Random().nextInt(best_neighbours.size()));
        System.out.println("random best neighbour -> col:"+rand_best.getColumn()+" , row:"+rand_best.getRow());
        for(int i=0; i<Configurations.CHESS_SIZE; i++) {
            if(chess_board.getQueens()[i].getColumn() == rand_best.getColumn()) {
                chess_board.getQueens()[i].setRow(rand_best.getRow());
            }
        }
    }

    public Neighbour getNeighbour(int col, int row) {
        for(int i=0; i<Configurations.CHESS_NEIGHBOURS; i++) {
            if(neighbours[i].getColumn() == col && neighbours[i].getRow() == row) {
                return neighbours[i];
            }
        }
        return neighbours[0];
    }

    public Neighbour[] getNeighbours() {
        return neighbours;
    }

}
