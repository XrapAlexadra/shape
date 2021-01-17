package edu.epam.shape.specification;

@FunctionalInterface
public interface Specification<T> {

    boolean specify(T t);
}
