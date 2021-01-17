package edu.epam.shape.validator;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.entity.Point;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConeValidatorTest extends Assert {

    ConeValidator coneValidator = ConeValidator.getInstance();

    @DataProvider
    public Object[][] isValidItemsNumberData() {
        return new Object[][]{
                {Arrays.asList(12d, -1d, 2.3, 5.0, 8.9), true},
                {Arrays.asList(1d, 1.2, -2.5), false},
                {Arrays.asList(0d, 1.8, -1d, 6.5), false},
                {Collections.singletonList(8d), false},
                {Arrays.asList(-1d, 2.5, 12d, 15, 8.7, 8.9), false}
        };
    }

    @DataProvider
    public Object[][] isValidConeData() {
        return new Object[][]{
                {new Cone(new Point(0, 0, 0), 5.0, 8.3), true},
                {new Cone(null, 5.0, 8.3), false},
                {new Cone(new Point(0, 0, 0), -5.0, 8.3), false},
                {new Cone(new Point(0, 0, 0), 5.0, -8.3), false},
                {new Cone(new Point(1, -1, -1), 1, 15), true}
        };
    }

    @Test(dataProvider = "isValidItemsNumberData")
    public void testIsValidItemsNumber(List<Double> data, boolean expected) {
       boolean actual = coneValidator.isValidItemsNumber(data);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isValidConeData")
    public void testIsValidCone(Cone cone, boolean expected) {
        boolean actual = coneValidator.isValidCone(cone);

        assertEquals(actual, expected);
    }
}