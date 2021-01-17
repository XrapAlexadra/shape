package edu.epam.shape.service.impl;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.entity.Point;
import edu.epam.shape.service.ConeService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ConeServiceImplTest extends Assert {

    ConeService coneService = ConeServiceImpl.getInstance();

    @DataProvider
    public Object[][] isBaseOnCoordinatePlaneData() {
        return new Object[][]{
                {new Cone(new Point(0, 0, 0), 5.0, 8.3), true},
                {new Cone(new Point(-1, -1, 1), 15, 3), false},
                {new Cone(new Point(-3, 0, 0), 4, 1), true},
                {new Cone(new Point(3, -4, 1), 15, 4), false},
        };
    }

    @DataProvider
    public Object[][] isConeData() {
        return new Object[][]{
                {new Cone(new Point(0, 0, 0), 5.0, 8.3), true},
                {new Cone(new Point(-1, -1, 1), -15, 3), false},
                {new Cone(new Point(-3, 0, 0), 4, 1), true},
                {new Cone(new Point(3, -4, 1), 15, -4), false},
                {new Integer(12), false},
        };
    }

    @Test
    public void testGetSquare() {
        Point baseCenter = new Point(0, 0, 0);
        Cone cone = new Cone(baseCenter, 3, 4);

        double actual = coneService.getSquare(cone);
        double expected = 113.0;

        assertEquals(actual, expected, 0.1);
    }

    @Test
    public void testGetVolume() {
        Point baseCenter = new Point(0, 0, 0);
        Cone cone = new Cone(baseCenter, 3, 4);

        double actual = coneService.getVolume(cone);
        double expected = 50.2;

        assertEquals(actual, expected, 0.1);
    }

    @Test
    public void testCalculateVolumeRatio() {
        Point baseCenter = new Point(0, 0, 0);
        Cone cone = new Cone(baseCenter, 3, 4);

        double actual = coneService.calculateVolumeRatio(cone, 1);
        double expected = 2.37;

        assertEquals(actual, expected, 0.01);
    }

    @Test(dataProvider = "isConeData")
    public void testIsCone(Object o, boolean expected) {
        boolean actual = coneService.isCone(o);

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "isBaseOnCoordinatePlaneData")
    public void testIsBaseOnCoordinatePlane(Cone cone, boolean expected) {
        boolean actual = coneService.isBaseOnCoordinatePlane(cone);

        assertEquals(actual, expected);
    }
}