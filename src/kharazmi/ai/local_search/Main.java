package kharazmi.ai.local_search;

import kharazmi.ai.local_search.queen_problem.ChessBoard;

public class Main {

    public static void main(String[] args) {
        ChessBoard[] chess_boards = new ChessBoard[Configurations.CHESS_RANDOM_GENERATION];

        System.out.println("\n"+">>> generating random chess board... "+"\n");
        for (int i = 0; i< Configurations.CHESS_RANDOM_GENERATION; i++) {
            chess_boards[i] = new ChessBoard();
        }

        for (int i = 0; i< Configurations.CHESS_RANDOM_GENERATION; i++) {
            chess_boards[i].printBoardInline(i+1);
        }
//        new ChessBoard().printBoardInline();
//        System.out.println(queens);
//
//        System.out.println("conflict lists:");
//        for (int i=0; i<8; i++) {
//            Integer me = queens.get(i);
//            for (int j=i+1; j<8; j++) {
//                Integer neighbor = queens.get(j);
//                if(me == neighbor) {
//                    System.out.println("col:"+i+" and col:"+j+" are in the same row.");
//                }
//                if(me-(j-i) > 0 && neighbor == (me-(j-i))) {
//                    System.out.println("col:"+i+" and col:"+j+" are in the same diameter (upper).");
//                }
//                if(me+(j-i) < 8 && neighbor == (me+(j-i))) {
//                    System.out.println("col:"+i+" and col:"+j+" are in the same diameter (lower).");
//                }
//            }
//        }
//        System.out.println("find heuristic::"+HillClimbingRandomRestart.findHeuristic(queenList));
//        System.out.println("print state::"+HillClimbingRandomRestart.generateBoard());
//        System.out.println("print state::"+HillClimbingRandomRestart.nextBoard(queenList));
//        HillClimbingRandomRestart.main(new String[8]);
//        N_Puzzle.main(new String[8]);

    }



}
