package kharazmi.ai.local_search;

/**
 * Created by hosseyn on 12/26/2018.
 */
public class Statistics {
    private String algorithm;
    private String heuristic;
    private int problem_count;
    public int solved_problems;
    public int unsolved_problems;
    public int step_cost;
    private int time_cost; // in seconds

    public Statistics(String alg, String heu, int count) {
        this.step_cost = 0;
        this.algorithm = alg;
        this.heuristic = heu;
        this.problem_count = count;
    }
    public void printResults() {
        System.out.println("%%%%%%%%%%% "+algorithm+" %%%%%%%%%%%");
        System.out.println("%%%%   random problmes = "+problem_count+"   %%%%");
        System.out.println("%%%%   heuristic = "+heuristic+"   %%%%");
        System.out.println("%%%%   time cost = "+time_cost+" seconds   %%%%");
        System.out.println("%%%%   number of steps = "+step_cost+"   %%%%");
        System.out.println("%%%%   number of solved problems = "+solved_problems+"   %%%%");
        System.out.println("%%%%   number of unsolved problems = "+unsolved_problems+"   %%%%");
        float percentage = (float) solved_problems/(solved_problems+unsolved_problems)*100;
        System.out.println("%%%%   Percentage of solubility = "+percentage+"%   %%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    public void update(int steps) {
        this.step_cost = steps;
    }

}
