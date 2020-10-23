package com.bilgeadam.java.examples.life_calculator.statistics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DataStore {

    /**
     * Updates new statistics to store number of children born
     *
     * @param nbOfChildren Number of children born
     * @param turn         Current turn
     */
    public void addChildren(int nbOfChildren, Number turn){
        for (int i = 0; i < nbOfChildren; i++)
            CreatureStatistics.AliveCreatures.incrementValue(turn.intValue());
    }

    /**
     * Updates statistics for dead creatures
     *
     * @param nbOfDead Number of dead creatures
     * @param turn     Current turn
     */
    public void diedCreatures(int nbOfDead, Number turn){
        for (int i = 0; i < nbOfDead; i++) {
            CreatureStatistics.AliveCreatures.decrementValue(turn.intValue());
            CreatureStatistics.DeadCreatures.incrementValue(turn.intValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        // Generate header values
        s.append(String.format("%" + CreatureStatistics.maxStringLength + "s", "Turn")).
                append("\t");

        Arrays.stream(CreatureStatistics.values()).forEach(e ->
                s.append(String.format("%" + CreatureStatistics.maxStringLength + "s", e.name())).append("\t"));
        s.append(System.getProperty("line.separator"));

        // Iterate for each turn stored
        for (int i = 0; i <= CreatureStatistics.getMaxTurn(); i++) {
            s.append(CreatureStatistics.generateStatistics(i)).
                    append(System.getProperty("line.separator"));
        }

        return s.toString();
    }

    public void printStatistics() throws IOException {
        FileWriter out = new FileWriter("src/resources/Statistics.txt");
        //File f = new File("src/resources/Statistics.txt");
        try {
            out.write(this.toString());
            out.flush();
        } finally {
            out.close();
        }

    }
}
