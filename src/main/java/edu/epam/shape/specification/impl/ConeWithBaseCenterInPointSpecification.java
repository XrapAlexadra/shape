package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.entity.Point;
import edu.epam.shape.specification.Specification;

public class ConeWithBaseCenterInPointSpecification implements Specification<Cone> {

    private Point point;

    public ConeWithBaseCenterInPointSpecification(Point point) {
        this.point = point;
    }

    @Override
    public boolean specify(Cone cone) {
       Point coneBaseCenter = cone.getBaseCenter();
       return point.equals(coneBaseCenter);
    }
}
