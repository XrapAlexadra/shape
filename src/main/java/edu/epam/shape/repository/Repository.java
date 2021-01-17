package edu.epam.shape.repository;

import edu.epam.shape.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    void add(T t);

    void remove(T t);

    T get(int index);

    List<T> findAll();

    List<T> sort (Comparator<? super T> comparator);

    List<T> query(Specification<T> specification);

    void clear();
}
