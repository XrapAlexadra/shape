package edu.epam.shape.service;

import edu.epam.shape.entity.Cone;

public interface ConeService {

    double getSquare(Cone cone);

    double getVolume(Cone cone);

    double calculateVolumeRatio(Cone cone, double sectionHeight);

    boolean isCone(Object o);

    boolean isBaseOnCoordinatePlane(Cone cone);
}
