package com.bilgeadam.java.examples.life_calculator.statistics;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

enum CreatureStatistics {
    DeadCreatures,  // Nb of dead creatures statistics
    AliveCreatures; // Nb of alive creatures statistics

    public static final int maxStringLength = 10;

    // A variable to store max turn acquired
    private static int maxTurn = 0;

    // Value is stored for each turn
    private final Map<Integer, Integer> value;

    /**
     * Constructor which initializes inner variables
     */
    CreatureStatistics() {
        value = new TreeMap<>();
    }


    /**
     * Increment value by 1 for given turn
     * @param turn Requested turn
     */
    protected void incrementValue(Integer turn) {
        CreatureStatistics.maxTurn = Math.max(CreatureStatistics.maxTurn, turn);

        value.put(turn, value.getOrDefault(turn, 0) + 1);
    }

    /**
     * Decrement value by 1 for given turn
     * @param turn Requested turn
     */
    protected void decrementValue(Integer turn){
        CreatureStatistics.maxTurn = Math.max(CreatureStatistics.maxTurn, turn);

        value.put(turn, value.getOrDefault(turn, 1) - 1);
    }

    /**
     *
     * @return max turn processed in the Enum
     */
    public static int getMaxTurn() {
        return maxTurn;
    }

    /**
     * Creates string representation for each and every turn stored.
     *
     * @return String representation of {@link CreatureStatistics#value}
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        value.forEach((k, v) -> stringBuilder.
                append(String.format("%" + maxStringLength + "s", k)).
                append("\t").
                append(String.format("%" + maxStringLength + "s", v)));

        return stringBuilder.toString();
    }

    /**
     * Creates string representation for each {@link CreatureStatistics#values()} for given turn.
     * @param turn Requested turn
     * @return All statistics of {@link CreatureStatistics#values()} in given turn
     */
    protected static String generateStatistics(int turn){
        StringBuilder s = new StringBuilder();

        s.append(String.format("%" + maxStringLength + "s", turn));

        //s.append(CreatureStatistics.AliveCreatures.value.get(turn)).
        //        append(CreatureStatistics.DeadCreatures.value.get(turn));

        Arrays.stream(CreatureStatistics.values()).forEach(e ->
                s.append(
                        String.format("%" + maxStringLength + "s", e.value.getOrDefault(turn, 0))).
                append("\t"));
        return s.toString();
    }

}
