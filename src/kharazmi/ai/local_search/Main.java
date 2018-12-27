package kharazmi.ai.local_search;

import kharazmi.ai.local_search.puzzle_problem.NPuzzleProblemSolver;
import kharazmi.ai.local_search.puzzle_problem.PuzzleBoard;
import kharazmi.ai.local_search.queen_problem.ChessBoard;
import kharazmi.ai.local_search.queen_problem.Heuristic;
import kharazmi.ai.local_search.queen_problem.NQueenProblemSolver;


public class Main {

    public static void main(String[] args) {
        Statistics stats;

        if(Configurations.CHESS_PROBLEM) {
            ChessBoard[] chess_boards = new ChessBoard[Configurations.CHESS_RANDOM_GENERATION];
            if(Configurations.TRACE_MODE) System.out.println("\n"+">>> generating random chess board... "+"\n");
            for (int i = 0; i< Configurations.CHESS_RANDOM_GENERATION; i++) {
                chess_boards[i] = new ChessBoard();
            }
            stats = new Statistics(Configurations.PROBLEM_8_QUEENS, Configurations.HILL_CLIMBING_STEEPEST_ASCENT, Configurations.CHESS_RANDOM_GENERATION);
            for (int i = 0; i< Configurations.CHESS_RANDOM_GENERATION; i++) {
                if(Configurations.TRACE_MODE) chess_boards[i].printBoard(i+1);
                while (true) {
                    NQueenProblemSolver solver = new NQueenProblemSolver(chess_boards[i], i);
                    stats.step_cost++;
                    if(!solver.solvable.equals(Configurations.PROBLEM_SOLVING)) {
                        System.out.print("\n");
                        if(Configurations.TRACE_MODE) System.out.println("$$$$$$$$$$$$$$$ problem "+solver.solvable+" $$$$$$$$$$$$$$$");
                        System.out.print("\n\n");
                        if(solver.solvable.equals(Configurations.PROBLEM_SOLVED)) stats.solved_problems++;
                        else if(solver.solvable.equals(Configurations.PROBLEM_UNSOLVED)) stats.unsolved_problems++;
                        break;
                    }
                }
            }
            System.out.print("\n");
            stats.printResults();
        }

        if(Configurations.PUZZLE_PROBLEM) {
            PuzzleBoard[] puzzle_boards = new PuzzleBoard[Configurations.PUZZLE_RANDOM_GENERATION];
            if(Configurations.TRACE_MODE) System.out.println("\n"+">>> generating random puzzle board... "+"\n");
            for (int i = 0; i< Configurations.PUZZLE_RANDOM_GENERATION; i++) {
                puzzle_boards[i] = new PuzzleBoard();
            }
            stats = new Statistics(Configurations.PROBLEM_8_PUZZLES, Configurations.HILL_CLIMBING_STEEPEST_ASCENT, Configurations.PUZZLE_RANDOM_GENERATION);
            for (int i = 0; i< Configurations.PUZZLE_RANDOM_GENERATION; i++) {
                if(Configurations.TRACE_MODE) puzzle_boards[i].printBoardInline(i+1);
                if(Configurations.TRACE_MODE) puzzle_boards[i].printBoard(i+1);
//            while (true) {
//                NPuzzleProblemSolver solver = new NPuzzleProblemSolver(puzzle_boards[i], i);
//                stats.step_cost++;
//                if(!solver.solvable.equals(Configurations.PROBLEM_SOLVING)) {
//                    System.out.print("\n");
//                    if(Configurations.TRACE_MODE) System.out.println("$$$$$$$$$$$$$$$ problem "+solver.solvable+" $$$$$$$$$$$$$$$");
//                    System.out.print("\n\n");
//                    if(solver.solvable.equals(Configurations.PROBLEM_SOLVED)) stats.solved_problems++;
//                    else if(solver.solvable.equals(Configurations.PROBLEM_UNSOLVED)) stats.unsolved_problems++;
//                    break;
//                }
//                }
            }
            System.out.print("\n");
            stats.printResults();
        }

        //        System.out.println("find heuristic::"+HillClimbingRandomRestart.findHeuristic(queenList));
//        System.out.println("print state::"+HillClimbingRandomRestart.generateBoard());
//        System.out.println("print state::"+HillClimbingRandomRestart.nextBoard(queenList));
//        HillClimbingRandomRestart.main(new String[8]);
//        N_Puzzle.main(new String[8]);

    }



}
