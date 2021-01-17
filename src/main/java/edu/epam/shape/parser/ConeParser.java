package edu.epam.shape.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConeParser {

    private static final Logger logger = LogManager.getLogger(ConeParser.class);

    private static ConeParser instance = new ConeParser();

    private static final String DOUBLE_MATCHER = "-?\\d+\\.?\\d*";
    private static final String NUMBER_SEPARATOR = " +";

    private ConeParser() {
    }

    public static ConeParser getInstance() {
        return instance;
    }

    public List<Double> parse(String line){
        List<Double> data = new ArrayList<>();
        String[] numbers = line.split(NUMBER_SEPARATOR);
        int i = 0;
        while (i < numbers.length){
            String temp = numbers[i];
            if(temp.matches(DOUBLE_MATCHER)){
                data.add(Double.parseDouble(temp));
            }
            else {
                logger.error("{} has invalid double number: {}!", line, temp);
                data.clear();
                break;
            }
            i++;
        }
        logger.info( "Parse: " + line + " to " + data);
        return data;
    }
}
