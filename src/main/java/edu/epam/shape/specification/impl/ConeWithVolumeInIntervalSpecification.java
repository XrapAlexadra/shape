package edu.epam.shape.specification.impl;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.service.ConeService;
import edu.epam.shape.service.impl.ConeServiceImpl;
import edu.epam.shape.specification.Specification;

public class ConeWithVolumeInIntervalSpecification implements Specification<Cone> {

    private final ConeService coneService = ConeServiceImpl.getInstance();

    private double bottomBound = 0;
    private double topBound;

    public ConeWithVolumeInIntervalSpecification(double topBound) {
        this.topBound = topBound;
    }

    public ConeWithVolumeInIntervalSpecification(double bottomBound, double topBound) {
        this.bottomBound = bottomBound;
        this.topBound = topBound;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean result = false;
        double coneVolume = coneService.getVolume(cone);
        if(coneVolume < topBound && coneVolume > bottomBound){
            result = true;
        }
        return result;
    }
}
