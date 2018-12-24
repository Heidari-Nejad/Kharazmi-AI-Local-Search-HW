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

    public void printBoardInline(int order) {
        System.out.println("***** random chess board "+order+" ***** ");
        System.out.print("*** ");
        for (int i=0; i<Configurations.CHESS_SIZE; i++) {
            System.out.print(" "+getBoard()[i].getRow()+" ");
        }
        System.out.print(" ***");
        System.out.print("\n");
        System.out.println("********************************");
        System.out.print("\n");
    }

    public Queen[] getBoard() {
        return board;
    }

}
