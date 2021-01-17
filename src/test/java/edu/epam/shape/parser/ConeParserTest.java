package edu.epam.shape.parser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConeParserTest extends Assert {

    ConeParser coneParser = ConeParser.getInstance();
    List<Double> emptyList = new ArrayList<>();

    @DataProvider
    public Object[][] coneParseData() {
        return new Object[][]{
                {"12 -1 2.3 5.0 8.9", Arrays.asList(12d, -1d, 2.3, 5.0, 8.9)},
                {"0 0 .0 5.0 8.9", emptyList},
                {"-1 -1 3 assert 8.9", emptyList},
                {"0 -1 -2 5,0 8.9", emptyList},
                {"12 -1i 2.3 5.0 8.9", emptyList}
        };
    }

    @Test(dataProvider = "coneParseData")
    public void testParse(String data, List<Double> expected) {
        List<Double> actual = coneParser.parse(data);

        assertEquals(actual, expected);
    }

}