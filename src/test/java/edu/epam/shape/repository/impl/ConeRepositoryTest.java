package edu.epam.shape.repository.impl;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.entity.Point;
import edu.epam.shape.specification.Specification;
import edu.epam.shape.specification.impl.ConeWithBaseCenterInPointSpecification;
import edu.epam.shape.specification.impl.ConeWithHeightInIntervalSpecification;
import edu.epam.shape.specification.impl.ConeWithRadiusInIntervalSpecification;
import edu.epam.shape.specification.impl.ConeWithVolumeInIntervalSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConeRepositoryTest extends Assert {

    ConeRepository coneRepository = ConeRepository.getInstance();
    List<Cone> coneList = new ArrayList<>();

    @BeforeMethod
    public void setUp() {
        coneList.add(new Cone(new Point(0, 0, 0), 5.0, 8.3));
        coneList.add(new Cone(new Point(-1, -1, 1), 15, 3));
        coneList.add(new Cone(new Point(-3, 0, 0), 4, 1));
        coneList.add(new Cone(new Point(3, -4, 0), 15, 4));
        coneList.add(new Cone(new Point(12, 12, 0), 4, 6));
        coneList.add(new Cone(new Point(3, -1, 2), 9.5, 10));
        coneList.add(new Cone(new Point(-1, -2, 0), 2, 5));
        coneList.add(new Cone(new Point(0, 0, 0), 7, 3.7));
        coneList.forEach(coneRepository::add);
    }

    @DataProvider
    public Object[][] queryData() {
        return new Object[][]{
                {new ConeWithHeightInIntervalSpecification(4, 12),
                        Arrays.asList(
                                new Cone(new Point(0, 0, 0), 5.0, 8.3),
                                new Cone(new Point(3, -1, 2), 9.5, 10),
                                new Cone(new Point(0, 0, 0), 7, 3.7)
                        )},
                {new ConeWithRadiusInIntervalSpecification(4),
                        Arrays.asList(
                                new Cone(new Point(-1, -1, 1), 15, 3),
                                new Cone(new Point(-3, 0, 0), 4, 1),
                                new Cone(new Point(0, 0, 0), 7, 3.7)
                        )},
                {new ConeWithBaseCenterInPointSpecification(new Point(0, 0, 0)),
                        Arrays.asList(
                                new Cone(new Point(0, 0, 0), 5.0, 8.3),
                                new Cone(new Point(0, 0, 0), 7, 3.7)
                        )},
                {new ConeWithVolumeInIntervalSpecification(100, 200),
                        Arrays.asList(
                                new Cone(new Point(-1, -1, 1), 15, 3),
                                new Cone(new Point(12, 12, 0), 4, 6),
                                new Cone(new Point(0, 0, 0), 7, 3.7)
                        )}
        };
    }

    @Test
    public void testAdd() {
        Cone cone = new Cone(new Point(11, 0, 0), 7, 3.7);
        coneRepository.add(cone);

        Cone actual = coneRepository.get(8);
        Cone expected = cone;

        assertEquals(actual, expected);
    }

    @Test
    public void testRemove() {
        Cone cone = coneRepository.get(0);
        coneRepository.remove(cone);

        Cone actual = coneRepository.get(0);
        Cone expected = new Cone(new Point(-1, -1, 1), 15, 3);

        assertEquals(actual, expected);
    }

    @Test
    public void testGet() {
        Cone actual = coneRepository.get(0);
        Cone expected = new Cone(new Point(0, 0, 0), 5.0, 8.3);

        assertEquals(actual, expected);
    }

    @Test
    public void testFindAll() {
        List<Cone> actual = coneRepository.findAll();
        List<Cone> expected = coneList;

        assertEquals(actual, expected);
    }

    @Test
    public void testSort() {
        Comparator<Cone> comparator = Comparator.comparingDouble(Cone::getHeight);
        coneList.sort(comparator);

        List<Cone> actual = coneRepository.sort(comparator);
        List<Cone> expected = coneList;

        assertEquals(actual, expected);
    }

    @Test(dataProvider = "queryData")
    public void testQuery(Specification<Cone> specification, List<Cone> expected) {
        List<Cone> actual = coneRepository.query(specification);

        assertEquals(actual, expected);
    }

    @Test
    public void clear(){
        coneRepository.clear();

        int actual = coneRepository.findAll().size();
        int expected = 0;

        assertEquals(actual, expected);
    }
    @AfterMethod
    public void tearDown() {
        coneList.clear();
        coneRepository.clear();
    }
}