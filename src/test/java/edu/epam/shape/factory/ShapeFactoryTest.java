package edu.epam.shape.factory;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.entity.Point;
import edu.epam.shape.exception.ConeException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ShapeFactoryTest extends Assert {

    ShapeFactory shapeFactory = ShapeFactory.getInstance();

    @DataProvider
    public Object[][] createConeData() {
        return new Object[][]{
                {Arrays.asList(12d, -1d, 2.3, 5.0, 8.9), new Cone(new Point(12, -1, 2.3), 5.0, 8.9)},
                {Arrays.asList(0d, 0d, 0d, 1d, 8.9), new Cone(new Point(0, 0, 0), 1, 8.9)},
                {Arrays.asList(-1d, -1d, 1d, 1d, 1d), new Cone(new Point(-1, -1, 1), 1, 1)},
                {Arrays.asList(-14d, 12d, 25d, 44d, 87d), new Cone(new Point(-14, 12, 25), 44, 87)},
        };
    }

    @Test(dataProvider = "createConeData")
    public void testCreateCone(List<Double> data, Cone expected) throws ConeException {
        Cone actual = shapeFactory.createCone(data);

        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ConeException.class)
    public void testCreateConeWrongData() throws ConeException {
        List<Double> data = Arrays.asList(-1.2, -2.3, -3.5, -15.7, 53d);
        shapeFactory.createCone(data);
    }

    @Test(expectedExceptions = ConeException.class)
    public void testCreateConeException() throws ConeException {
        List<Double> data = Arrays.asList(-1.2, -2.3, -3.5);
        shapeFactory.createCone(data);
    }

}