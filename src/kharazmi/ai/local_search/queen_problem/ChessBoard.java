package kharazmi.ai.local_search.queen_problem;

import kharazmi.ai.local_search.Configurations;

import java.util.Random;

/**
 * Created by hosseyn on 12/24/2018.
 *
 */
public class ChessBoard {
    private Queen[] board;
    public ChessBoard() {
        generateBoard();
    }

    private void generateBoard() {
        board = new Queen[Configurations.CHESS_SIZE];
        Random rndm = new Random();
        for(int i=0; i<Configurations.CHESS_SIZE; i++){
            board[i] = new Queen(rndm.nextInt(Configurations.CHESS_SIZE), i);
        }
    }

    public void printQueens(int order) {
        System.out.println("***** random chess board "+order+" ***** ");
        System.out.print("*** ");
        for (int i=0; i<Configurations.CHESS_SIZE; i++) {
            System.out.print(" "+getQueens()[i].getRow()+" ");
        }
        System.out.print(" ***");
        System.out.print("\n");
        System.out.println("********************************");
        System.out.println("h = "+Heuristic.attackingPairs(getQueens()));
        System.out.print("\n");
    }

    public void printBoard(int order) {
        System.out.println("*** random chess board "+order+" *** ");
        for (int i=0; i<Configurations.CHESS_SIZE; i++) {
            for (int j=0; j<Configurations.CHESS_SIZE; j++) {
                if (i == getQueens()[j].getRow()) {
                    System.out.print(" # ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("****************************");
        System.out.println("attacking pairs = "+Heuristic.attackingPairs(getQueens()));
        System.out.print("\n");
    }

    public Queen[] getQueens() {
        return board;
    }

}
