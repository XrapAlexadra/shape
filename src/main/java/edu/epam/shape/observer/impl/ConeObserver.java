package edu.epam.shape.observer.impl;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.entity.ConeParameter;
import edu.epam.shape.observer.ShapeObserver;
import edu.epam.shape.service.ConeService;
import edu.epam.shape.service.impl.ConeServiceImpl;
import edu.epam.shape.storage.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeObserver implements ShapeObserver<Cone> {

    private static final Logger logger = LogManager.getLogger(ConeObserver.class);

    private final ConeService coneService = ConeServiceImpl.getInstance();
    private final Warehouse warehouse = Warehouse.getInstance();

    @Override
    public void performedParameters(Cone cone) {
        double square = coneService.getSquare(cone);
        double volume = coneService.getVolume(cone);
        ConeParameter coneParameter = new ConeParameter(square, volume);
        long id = cone.getId();
        warehouse.put(id, coneParameter);
        logger.info("Performed cone: {} parameters in warehouse: square = {}, volume {}.", cone, square, volume);
    }
}
