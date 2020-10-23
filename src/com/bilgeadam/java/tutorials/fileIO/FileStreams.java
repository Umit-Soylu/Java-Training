package com.bilgeadam.java.tutorials.fileIO;

import java.io.*;

public class FileStreams {

    // These are the results that will be written to a file
    String[] results = new String[]{"test1", "tests2"};

    // File Path
    static final String path = "src" + File.separator + "resources" + File.separator;


    /**
     * This method writes byte array to a file
     * @throws IOException
     */
    public void printResults() throws IOException {
        // Stream to be used
        FileOutputStream fileOutputStream = new FileOutputStream(path + "stream.txt");

        byte[] output = new byte[]{31, 32, 43, 21, 77};

        byte[] output2 = ("This is a demo file.").getBytes();

        try {
            fileOutputStream.write(output);
            fileOutputStream.write(output2);
            fileOutputStream.flush();
        } finally {
            fileOutputStream.close();
        }
    }


    /**
     * This method writes character array or a string to a file
     * @throws IOException
     * @param fileName    The file to write results
     */
    public void printToFile(String fileName) throws IOException {
        File f = new File(path + fileName);

        System.out.println("f.getAbsolutePath() = " + f.getAbsolutePath());

        FileWriter fileWriter = new FileWriter(f);

        String s = "This is a second demo.";

        try {
            fileWriter.write(s);
        } finally {
            fileWriter.close();
        }
    }

    public void readFromFile() throws IOException {
        File f = new File(path + "Terminal");
        int c;
        if (f.exists()){
            FileReader reader = new FileReader(f);

            try {
                while ((c = reader.read()) != -1)
                    System.out.println((char) c);
            } finally {
                reader.close();
            }
        }
    }

    public static void writeTerminalToFile(String fileName) throws IOException {
        // The file to write Terminal input
        File f = new File(path + fileName);
        FileWriter fileWriter = new FileWriter(f);

        // Acquire input from terminal.
        InputStreamReader inputReader = new InputStreamReader(System.in);

        // Character to receive input as char
        char input;

        try {
            do {
                input = (char) inputReader.read();
                fileWriter.write(input);
            } while (input != 'Q');
        } finally {
            fileWriter.close();
        }
    }

    /**
     * This method reads form file and prints each line.
     *
     * @param fileName File to be read
     * @throws IOException
     */
    public static void readStream(String fileName) throws IOException {
        File f = new File(path + fileName);

        // Read from file
        if (f.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;

            br.lines().forEach(System.out::println);

            //while((line = br.readLine()) != null)
            //    System.out.println(line);
        }
    }

}
