package edu.epam.shape.validator;

import edu.epam.shape.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ConeValidator {

    private static final Logger logger = LogManager.getLogger(ConeValidator.class);

    private static ConeValidator instance = new ConeValidator();

    public ConeValidator() {
    }

    public static ConeValidator getInstance() {
        return instance;
    }

    public boolean isValidItemsNumber(List<Double> data){
        boolean isValid = true;
        if (data.size() != 5) {
            logger.error("Count of numbers in line is incorrect: {}", data);
            isValid = false;
        }
        return isValid;
    }

    public boolean isValidCone(Cone cone){
        boolean isValid = true;
        if(cone.getBaseCenter() == null){
            isValid = false;
            logger.error("Invalid cone: base center is null :" + cone);
        }
        if(cone.getRadius() <= 0){
            isValid = false;
            logger.error("Invalid cone: radius can't be 0 or less than 0  :" + cone);
        }
        if(cone.getHeight() <= 0){
            isValid = false;
            logger.error("Invalid cone: height can't be 0 or less than 0  :" + cone);
        }
        return isValid;
    }
}
