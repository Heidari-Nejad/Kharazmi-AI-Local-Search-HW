package kharazmi.ai.local_search;

/**
 * Created by hosseyn on 12/26/2018.
 */
public class Statistics {
    private String algorithm;
    private String heuristic;
    public int step_cost;
    private int time_cost; // in seconds

    public Statistics(String alg, String heu) {
        this.step_cost = 0;
        this.algorithm = alg;
        this.heuristic = heu;
    }
    public void printResults() {
        System.out.println("%%%%%%%%%%% "+algorithm+" %%%%%%%%%%%");
        System.out.println("%%%%   heuristic = "+heuristic+"   %%%%");
        System.out.println("%%%%   time cost = "+time_cost+" seconds   %%%%");
        System.out.println("%%%%   number of steps = "+step_cost+"   %%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    public void update(int steps) {
        this.step_cost = steps;
    }

}
