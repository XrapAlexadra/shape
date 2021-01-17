package edu.epam.shape.reader;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ShapeReaderTest extends Assert {

    List<String> rightLines = new ArrayList<>();
    ShapeReader shapeReader = new ShapeReader();

    @BeforeMethod
    public void setUp() {
        rightLines.add("12 13 5 7 5");
        rightLines.add("0 0 0 12 8");
        rightLines.add("12 12 12");
        rightLines.add("0 0 0 -12 8");
        rightLines.add("-1 -2 -3 12 -8");
        rightLines.add("1 1 1 5 0");
        rightLines.add("1 -2 -4 15 3");
        rightLines.add("5 4 -3 0 12");
    }

    @Test
    public void readLines() {
        List<String> actual = shapeReader.readLines();
        List<String> expected = rightLines;

        assertEquals(actual, expected);
    }

    @Test
    public void readLinesWrongFileName(){
        List<String> actual = shapeReader.readLines("cone.txt");
        List<String> expected = new ArrayList<>();

        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        rightLines.clear();
    }
}