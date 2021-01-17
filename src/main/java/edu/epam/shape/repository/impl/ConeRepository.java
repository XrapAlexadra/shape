package edu.epam.shape.repository.impl;

import edu.epam.shape.entity.Cone;
import edu.epam.shape.repository.Repository;
import edu.epam.shape.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConeRepository implements Repository<Cone> {

    private static final Logger logger = LogManager.getLogger(ConeRepository.class);
    private static final ConeRepository instance = new ConeRepository();

    private List<Cone> coneList = new ArrayList<>();

    private ConeRepository() {
    }

    public static ConeRepository getInstance() {
        return instance;
    }

    @Override
    public void add(Cone cone) {
        coneList.add(cone);
        logger.info("Add cone: {} in repository.", cone);
    }

    @Override
    public void remove(Cone cone) {
        coneList.remove(cone);
        logger.info("Remove cone: {} from repository.", cone);
    }

    @Override
    public Cone get(int index) {
        Cone cone= coneList.get(index);
        logger.info("Find cone: {} in repository by index: {}.", cone, index);
        return cone;
    }

    @Override
    public List<Cone> findAll() {
        List<Cone> result = new ArrayList<>(coneList);
        return result;
    }

    @Override
    public List<Cone> sort(Comparator<? super Cone> comparator) {
        List<Cone> sortList = new ArrayList<>(coneList);
        sortList.sort(comparator);
        logger.info("Find all cones in repository and sort them.");
        return sortList;
    }

    @Override
    public List<Cone> query(Specification<Cone> specification) {
        List<Cone> listResult = coneList.stream().filter(specification::specify).collect(Collectors.toList());
        logger.info("Find all cones in repository with specification.");
        return listResult;
    }

    @Override
    public void clear() {
        coneList.clear();
        logger.info("Clear cone repository.");
    }
}
