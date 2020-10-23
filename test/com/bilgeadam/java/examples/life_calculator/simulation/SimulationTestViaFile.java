package com.bilgeadam.java.examples.life_calculator.simulation;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimulationTestViaFile {
    // Location of the file
    static final String path = "test" + File.separator + "resources" + File.separator;

    // This regex captures 'Enum' : 'Value'
    static final String regex = "\\s*(\\w+)\\s*:\\s*(\\d+)\\s*";

    Simulation testClass;

    @Test
    public void testFileRead() throws IOException {
        readConfiguration();

        testClass =  new Simulation(Configuration.length.getValue().intValue(),
                Configuration.width.getValue().intValue(),
                Configuration.nbOfEntities.getValue().intValue(),
                Configuration.foodRatio.getValue().floatValue() / 100);

        for (int i = 0; i < Configuration.turn.getValue().intValue(); i++) {
            testClass.endTurn();
        }

        System.out.println(testClass.getStatistics().toString());
    }

    /**
     * Reads test configuration from file and fills {@link Configuration}
     */
    private void readConfiguration() throws FileNotFoundException {
        BufferedReader inputStream = new BufferedReader(new FileReader(path + "SimulationTestConfiguration.txt"));

        AtomicReference<Matcher> m = new AtomicReference<>();
        Pattern p = Pattern.compile(regex);

        inputStream.lines().forEach(e -> {
            m.set(p.matcher(e));
            m.get().matches();
            Configuration.valueOf(m.get().group(1)).setValue(Integer.valueOf(m.get().group(2)));
        });
        //Arrays.stream(Configuration.values()).forEach(e -> System.out.println(e.toString() + ":" + e.getValue()));
    }
}
