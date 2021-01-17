package edu.epam.shape.observer;

import edu.epam.shape.entity.Shape;

public interface ShapeObserver<T extends Shape> {

    void performedParameters(T t);

}
