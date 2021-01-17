package edu.epam.shape.observer;

import edu.epam.shape.entity.Shape;

public interface Observable<E extends Shape> {

    void attach(ShapeObserver<E> observer);

    void detach(ShapeObserver<E> observer);

    void notifyObserver();
}
