package kharazmi.ai.local_search.queen_problem;

import kharazmi.ai.local_search.Configurations;

/**
 * Created by hosseyn on 12/24/2018.
 *
 */
public class Heuristic {
    public static int attakingPairs(Queen[] queens) {
        int h = 0;
        for (int i=0; i< Configurations.CHESS_SIZE; i++) {
            Queen currentQueen = queens[i];
            for (int j=i+1; j< Configurations.CHESS_SIZE; j++) {
                Queen nextQueen = queens[j];
                if(currentQueen.getRow() == nextQueen.getRow()) {
                    h++;
                    System.out.println("col:"+i+" and col:"+j+" are in the same row.");
                }
                if(currentQueen.getRow()-(j-i) > 0 && nextQueen.getRow() == (currentQueen.getRow()-(j-i))) {
                    h++;
                    System.out.println("col:"+i+" and col:"+j+" are in the same diameter (upper).");
                }
                if(currentQueen.getRow()+(j-i) < Configurations.CHESS_SIZE && nextQueen.getRow() == (currentQueen.getRow()+(j-i))) {
                    h++;
                    System.out.println("col:"+i+" and col:"+j+" are in the same diameter (lower).");
                }
            }
        };
        return h;
    }
}
