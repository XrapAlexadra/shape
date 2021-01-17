package edu.epam.shape.factory;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.entity.Point;
import edu.epam.shape.exception.ConeException;
import edu.epam.shape.validator.ConeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShapeFactory {

    private static final Logger logger = LogManager.getLogger(ShapeFactory.class);

    private static ShapeFactory instance = new ShapeFactory();

    private ConeValidator coneValidator = ConeValidator.getInstance();

    public ShapeFactory() {
    }

    public static ShapeFactory getInstance() {
        return instance;
    }

    public Cone createCone(List<Double> data) throws ConeException {
        if(!coneValidator.isValidItemsNumber(data)){
            logger.error("Count of numbers in line is incorrect : {}", data);
            throw new ConeException("Count of numbers in line is incorrect :" + data);
        }
        Point baseCenter = new Point(data.get(0), data.get(1), data.get(2));
        Cone cone = new Cone(baseCenter, data.get(3), data.get(4));
        logger.info("Create new cone: {}", cone);
        if(!coneValidator.isValidCone(cone)){
            logger.error("Cone is invalid : {}", cone);
            throw new ConeException("Cone is invalid :" + data);
        }
        return cone;
    }
}
