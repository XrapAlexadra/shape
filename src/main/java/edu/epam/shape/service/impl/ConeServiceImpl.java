package edu.epam.shape.service.impl;

import edu.epam.shape.entity.Point;
import edu.epam.shape.entity.Cone;
import edu.epam.shape.service.ConeService;
import edu.epam.shape.validator.ConeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeServiceImpl implements ConeService {

    private static final Logger logger = LogManager.getLogger(ConeServiceImpl.class);

    private static ConeServiceImpl instance = new ConeServiceImpl();
    private ConeValidator coneValidator = ConeValidator.getInstance();

    private ConeServiceImpl() {
    }

    public static ConeServiceImpl getInstance() {
        return instance;
    }

    @Override
    public double getSquare(Cone cone) {
        double height = cone.getHeight();
        double radius = cone.getRadius();
        double generatrix = Math.sqrt(radius * radius + height * height);
        double square = Math.PI * radius * (radius + generatrix);
        logger.info("Calculate area of cone: {}.", cone);
        return square;
    }

    @Override
    public double getVolume(Cone cone) {
        double height = cone.getHeight();
        double radius = cone.getRadius();
        double volume = Math.PI * radius * radius * height / 3;
        logger.info("Calculate volume of cone: {}.", cone);
        return volume;
    }

    @Override
    public double calculateVolumeRatio(Cone cone, double sectionHeight) {
        double coneHeight = cone.getHeight();
        double result = 0;
        if (sectionHeight < coneHeight && sectionHeight > 0) {
            double newConeHeight = coneHeight - sectionHeight;
            result = (Math.pow(coneHeight, 3) - Math.pow(newConeHeight, 3)) / Math.pow(newConeHeight, 3);
            logger.info("Calculate volume ratio of cone: {} section on height {}.", cone, sectionHeight);
        }
        logger.info("Can't Calculate volume ratio of cone: {} section on invalid height {}.", cone, sectionHeight);
        return result;
    }

    @Override
    public boolean isCone(Object o) {
        boolean result = false;
        if (o instanceof Cone) {
            result = coneValidator.isValidCone((Cone) o);
            logger.info("Object: {} is cone.", o);
        }
        logger.info("Object: {} isn't cone.", o);
        return result;
    }

    @Override
    public boolean isBaseOnCoordinatePlane(Cone cone) {
        boolean result = false;
        Point baseCenter = cone.getBaseCenter();
        if (baseCenter.getPointZ() == 0) {
            result = true;
            logger.info("Cone: {} base center is on coordinate plane", cone);
        }
        logger.info("Cone: {} base center isn't on coordinate plane", cone);
        return result;
    }

}
