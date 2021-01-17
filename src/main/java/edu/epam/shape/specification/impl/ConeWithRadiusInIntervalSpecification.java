package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.specification.Specification;

public class ConeWithRadiusInIntervalSpecification implements Specification<Cone> {

    private double bottomBound = 0;
    private double topBound;


    public ConeWithRadiusInIntervalSpecification(double topBound) {
        this.topBound = topBound;
    }

    public ConeWithRadiusInIntervalSpecification(double bottomBound, double topBound) {
        this.bottomBound = bottomBound;
        this.topBound = topBound;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean result = false;
        double coneRadius = cone.getRadius();
        if(coneRadius < topBound && coneRadius > bottomBound){
            result = true;
        }
        return result;
    }
}
