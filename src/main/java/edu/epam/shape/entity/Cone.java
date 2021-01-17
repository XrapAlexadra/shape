package edu.epam.shape.entity;

import edu.epam.shape.observer.Observable;
import edu.epam.shape.observer.ShapeObserver;
import edu.epam.shape.util.IndexGenerator;

public class Cone extends Shape implements Observable<Cone> {

    private static final IndexGenerator INDEX_GENERATOR = new IndexGenerator();

    private long id;
    private Point baseCenter;
    private double height;
    private double radius;
    private ShapeObserver<Cone> observer;

    {
        id = INDEX_GENERATOR.getId();
    }

    public Cone(Point baseCenter, double height, double radius) {
        this.baseCenter = baseCenter;
        this.height = height;
        this.radius = radius;
    }

    public long getId() {
        return id;
    }

    public Point getBaseCenter() {
        return baseCenter;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public void setBaseCenter(Point baseCenter) {
        this.baseCenter = baseCenter;
        notifyObserver();
    }

    public void setHeight(double height) {
        this.height = height;
        notifyObserver();
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObserver();
    }

    @Override
    public void detach(ShapeObserver<Cone> observer) {
        this.observer = null;
    }

    @Override
    public void attach(ShapeObserver<Cone> observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            observer.performedParameters(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return Double.compare(cone.radius, radius) == 0 &&
                baseCenter.equals(cone.baseCenter) &&
                Double.compare(cone.height, height) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = baseCenter.hashCode();
        result = prime * result + Double.hashCode(height);
        result = prime * result + Double.hashCode(radius);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cone{");
        sb.append("id=").append(id);
        sb.append(", baseCenter=").append(baseCenter);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }
}
