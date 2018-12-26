package kharazmi.ai.local_search.queen_problem;

import kharazmi.ai.local_search.Configurations;

import java.util.List;
import java.util.Random;

/**
 * Created by hosseyn on 12/24/2018.
 *
 */
public class ChessBoard {
    private Queen[] queens;
    public ChessBoard() {
        generateBoard();
    }

    private void generateBoard() {
        queens = new Queen[Configurations.CHESS_SIZE];
        Random rndm = new Random();
        for(int i=0; i<Configurations.CHESS_SIZE; i++){
            int rand_num = rndm.nextInt(Configurations.CHESS_SIZE);
            queens[i] = new Queen(rand_num, i);
        }
    }

    public void printQueens(int order) {
        System.out.println("***** random chess queens "+order+" ***** ");
        System.out.print("*** ");
        for (int i=0; i<Configurations.CHESS_SIZE; i++) {
            System.out.print(" "+getQueens()[i].getRow()+" ");
        }
        System.out.print(" ***");
        System.out.print("\n");
        System.out.println("********************************");
        System.out.println("h = "+Heuristic.attackingPairs(getQueens()));
    }

    public void printBoard(int order) {
        System.out.println("*** random chess board "+order+" *** ");
        for (int row=0; row<Configurations.CHESS_SIZE; row++) {
            for (int col=0; col<Configurations.CHESS_SIZE; col++) {
                if (row == getQueens()[col].getRow()) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("****************************");
        System.out.println("attacking pairs = "+Heuristic.attackingPairs(getQueens()));
    }

    public static void printBoardWithNeighbours(int order, NQueenProblemSolver solver) {
        System.out.println("*** random chess board "+order+" *** ");
        for (int row=0; row<Configurations.CHESS_SIZE; row++) {
            for (int col=0; col<Configurations.CHESS_SIZE; col++) {
                if (row == solver.getChessBoard().getQueens()[col].getRow()) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" "+solver.getNeighbour(col, row).getValue()+" ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("****************************");
        System.out.println("attacking pairs = "+Heuristic.attackingPairs(solver.getChessBoard().getQueens()));
    }

    public Queen[] getQueens() {
        return queens;
    }

}
