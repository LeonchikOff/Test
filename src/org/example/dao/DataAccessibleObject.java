package org.example.dao;

import java.util.List;
import java.util.Optional;

public interface DataAccessibleObject<E, I> {

    E save(E entity);

    void update(E entity);

    Optional<E> findById(I id);

    boolean deleteById(I id);

    List<E> findAll();

}
