package kharazmi.ai.local_search;

/**
 * Created by hosseyn on 12/24/2018.
 */
public class Configurations {
    public static int CHESS_SIZE = 8 ;
    public static int CHESS_RANDOM_GENERATION = 12 ;
    public static int CHESS_NEIGHBOURS = Configurations.CHESS_SIZE*(Configurations.CHESS_SIZE-1);

    public static String HILL_CLIMBING_STOCHASTIC = "stochastic";
    public static String SIMULATED_ANNEALING = "simulated_annealing";
    public static String HILL_CLIMBING_FIRST_CHOICE = "first_choice";
    public static String HILL_CLIMBING_RANDOM_RESTART = "random_restart";
    public static String HILL_CLIMBING_STEEPEST_ASCENT = "steepest_ascent";
}
