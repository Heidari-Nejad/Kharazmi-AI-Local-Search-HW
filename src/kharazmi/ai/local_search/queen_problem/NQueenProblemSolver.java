package kharazmi.ai.local_search.queen_problem;

import kharazmi.ai.local_search.Configurations;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Created by hosseyn on 12/24/2018.
 *
 */
public class NQueenProblemSolver {
    public String solvable;
    private Neighbour[] neighbours;
    private ChessBoard chess_board;
    private ArrayList<Neighbour> best_neighbours;

    public NQueenProblemSolver(ChessBoard board, int order) {
        solvable = Configurations.PROBLEM_SOLVING;
        chess_board = board;
        generateNeighbours();
        neighbourValueComputing();
        bestNeighboursResolver();
//        printNeighboursInline();
        if(Objects.equals(solvable, Configurations.PROBLEM_SOLVING)) updateChessBoard();
        if(Configurations.TRACE_MODE) System.out.print("\n");
        if(Configurations.TRACE_MODE) ChessBoard.printBoardWithNeighbours(order+1, this);
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
        if(Heuristic.attackingPairs(chess_board.getQueens()) == 0) solvable = Configurations.PROBLEM_SOLVED;
        else if(Heuristic.attackingPairs(chess_board.getQueens()) <= best_value) solvable = Configurations.PROBLEM_UNSOLVED;
        if (Configurations.TRACE_MODE) System.out.println(">> best value: "+best_value);
        for(int i=0; i<Configurations.CHESS_NEIGHBOURS; i++){
            if(best_value == neighbours[i].getValue()) {
                if(Configurations.TRACE_MODE) System.out.println(">> best neighbour added -> col:"+neighbours[i].getColumn()+" , row:"+neighbours[i].getRow()+" , value:"+neighbours[i].getValue());
                best_neighbours.add(new Neighbour(neighbours[i].getRow(), neighbours[i].getColumn(), neighbours[i].getValue()));
            }
        }
    }

    // update queens and neighbours array
    // old queen must be a neighbour now, best neighbour now is a queen
    public void updateChessBoard() {
        Neighbour rand_best = best_neighbours.get(new Random().nextInt(best_neighbours.size()));
        if(Configurations.TRACE_MODE) System.out.println("random best neighbour -> col:"+rand_best.getColumn()+" , row:"+rand_best.getRow()+" , value:"+rand_best.getValue());
        int old_queen_row = chess_board.getQueens()[rand_best.getColumn()].getRow();
        chess_board.getQueens()[rand_best.getColumn()].setRow(rand_best.getRow());
        getNeighbour(rand_best.getColumn(), rand_best.getRow()).setRow(old_queen_row);
        neighbourValueComputing();
    }

    public Neighbour getNeighbour(int col, int row) {
        for(int i=0; i<Configurations.CHESS_NEIGHBOURS; i++) {
            if(neighbours[i].getColumn() == col && neighbours[i].getRow() == row) {
                return neighbours[i];
            }
        }
        return new Neighbour(row, col, -1);
    }

    public void printNeighboursInline() {
        if (Configurations.TRACE_MODE) System.out.println(">> neighbours: ");
        for(int i=0; i<Configurations.CHESS_NEIGHBOURS; i++) {
            if (Configurations.TRACE_MODE) System.out.print(" "+neighbours[i].getColumn()+":"+neighbours[i].getRow()+":"+neighbours[i].getValue());
        }
    }

    public Neighbour[] getNeighbours() {
        return neighbours;
    }

    public ChessBoard getChessBoard() {
        return chess_board;
    }

}

