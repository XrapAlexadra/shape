package edu.epam.shape.util;

public class IndexGenerator {

    private long idCount = 0;

    public long getId() {
        return idCount++;
    }
}
