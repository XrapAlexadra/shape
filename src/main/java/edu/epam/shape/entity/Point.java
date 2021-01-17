package edu.epam.shape.entity;

public class Point {

    private double pointX;
    private double pointY;
    private double pointZ;

    public Point(double pointX, double pointY, double pointZ) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.pointZ = pointZ;
    }

    public double getPointX() {
        return pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public double getPointZ() {
        return pointZ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return point.pointX == pointX && point.pointY == pointY && point.pointZ == pointZ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = Double.hashCode(pointX);
        result = prime * result + Double.hashCode(pointY);
        result = prime * result + Double.hashCode(pointZ);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("pointX=").append(pointX);
        sb.append(", pointY=").append(pointY);
        sb.append(", pointZ=").append(pointZ);
        sb.append('}');
        return sb.toString();
    }
}
