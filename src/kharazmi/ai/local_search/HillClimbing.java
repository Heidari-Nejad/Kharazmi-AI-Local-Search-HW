package kharazmi.ai.local_search;

/**
 * Created by hosseyn on 12/27/2018.
 *
 */
public class HillClimbing {
    public static int steepestAscent(int current, int best_neighbour) {
        if(best_neighbour < current) return best_neighbour;
        else return current;
    }
}


