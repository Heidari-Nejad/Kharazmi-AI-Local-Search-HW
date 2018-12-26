package kharazmi.ai.local_search;

import kharazmi.ai.local_search.queen_problem.ChessBoard;
import kharazmi.ai.local_search.queen_problem.Heuristic;
import kharazmi.ai.local_search.queen_problem.NQueenProblemSolver;


public class Main {

    public static void main(String[] args) {
        ChessBoard[] chess_boards = new ChessBoard[Configurations.CHESS_RANDOM_GENERATION];

        System.out.println("\n"+">>> generating random chess board... "+"\n");
        for (int i = 0; i< Configurations.CHESS_RANDOM_GENERATION; i++) {
            chess_boards[i] = new ChessBoard();
        }

        Statistics stats = new Statistics(Configurations.PROBLEM_8_QUEENS, Configurations.HILL_CLIMBING_STEEPEST_ASCENT);
        for (int i = 0; i< Configurations.CHESS_RANDOM_GENERATION; i++) {
            if(Configurations.TRACE_MODE) chess_boards[i].printBoard(i+1);
            while (true) {
                new NQueenProblemSolver(chess_boards[i], i);
                if(Heuristic.attackingPairs(chess_boards[i].getQueens()) == 0) {
                    if(Configurations.TRACE_MODE) System.out.println("$$$$$$$$$$$$$$$ problem solved $$$$$$$$$$$$$$$");
                    stats.step_cost++;
                    System.out.print("\n");
                    break;
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        stats.printResults();

//        System.out.println("find heuristic::"+HillClimbingRandomRestart.findHeuristic(queenList));
//        System.out.println("print state::"+HillClimbingRandomRestart.generateBoard());
//        System.out.println("print state::"+HillClimbingRandomRestart.nextBoard(queenList));
//        HillClimbingRandomRestart.main(new String[8]);
//        N_Puzzle.main(new String[8]);

    }



}
