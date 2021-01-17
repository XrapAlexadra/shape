package edu.epam.shape.entity;

public class ConeParameter {

    private double square;
    private double volume;

    public ConeParameter() {
    }

    public ConeParameter(double square, double volume) {
        this.square = square;
        this.volume = volume;
    }

    public double getArea() {
        return square;
    }

    public void setArea(double square) {
        this.square = square;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConeParameter that = (ConeParameter) o;
        return square == that.square && volume == that.volume;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = Double.hashCode(square);
        result = prime * result + Double.hashCode(volume);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ShapeParameter{");
        sb.append("square=").append(square);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
