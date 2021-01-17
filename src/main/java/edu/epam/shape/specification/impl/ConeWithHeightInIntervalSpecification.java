package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.specification.Specification;

public class ConeWithHeightInIntervalSpecification implements Specification<Cone> {

    private double bottomBound;
    private double topBound;

    public ConeWithHeightInIntervalSpecification(double topBound) {
        this.topBound = topBound;
    }

    public ConeWithHeightInIntervalSpecification(double bottomBound, double topBound) {
        this.bottomBound = bottomBound;
        this.topBound = topBound;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean result = false;
        double coneHeight = cone.getHeight();
        if(coneHeight < topBound && coneHeight > bottomBound){
            result = true;
        }
        return result;
    }
}
