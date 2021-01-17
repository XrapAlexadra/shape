package edu.epam.shape.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeReader {

    private static final Logger logger = LogManager.getLogger(ShapeReader.class);
    private static final String DEFAULT_FILE_NAME = "data/shape.txt";


    public List<String> readLines() {
        List<String> content = readLines(DEFAULT_FILE_NAME);
        return content;
    }

    public List<String> readLines(String fileName) {
        File file = new File(fileName);
        List<String> content = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            content = bufferedReader.lines().map(String::trim).collect(Collectors.toList());
            logger.info("Read from file: {} data: {}.", fileName, content);
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
        return content;
    }
}
