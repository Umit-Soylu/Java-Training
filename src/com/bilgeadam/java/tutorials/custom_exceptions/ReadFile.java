package com.bilgeadam.java.tutorials.custom_exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    private static final String path = "src" + File.separator;

    protected void myExceptionThrower() throws UnknownFileException {
        try {
            File f = new File(path + "TestFile.txt");
            FileInputStream fileInputStream = new FileInputStream(f);

        } catch (FileNotFoundException f){
            throw new UnknownFileException();
        }
    }

    protected void fileExceptionThrower() throws FileNotFoundException {
        File f = new File(path + "TestFile.txt");
        FileInputStream fileInputStream = new FileInputStream(f);

    }


    protected void fileExceptionLogger() throws IOException {
        try {
            File f = new File(path + "TestFile.txt");
            FileInputStream fileInputStream = new FileInputStream(f);
        } catch (FileNotFoundException f){
            throw new FileNotFoundLoggerException("ReadFile.java");
        }
    }

}
