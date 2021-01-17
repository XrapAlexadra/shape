package edu.epam.shape.storage;

import edu.epam.shape.entity.ConeParameter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static final Logger logger = LogManager.getLogger(Warehouse.class);
    private static Warehouse instance;

    private final Map<Long, ConeParameter> parameters = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void put(long id, ConeParameter coneParameter){
        parameters.put(id, coneParameter);
        logger.info("Put in warehouse by id: {} cone parameters: {}.", id, coneParameter);
    }

    public double getArea(long id) {
        double area = parameters.get(id).getArea();
        logger.info("Find in warehouse by id: {} area: {}", id, area);
        return area;
    }

    public double getVolume(long id) {
        double volume = parameters.get(id).getVolume();
        logger.info("Find in warehouse by id: {} volume: {}", id, volume);
        return volume;
    }
}
