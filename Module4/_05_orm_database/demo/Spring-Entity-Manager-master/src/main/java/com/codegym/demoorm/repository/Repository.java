package com.codegym.demoorm.repository;

import java.util.List;

public interface Repository <T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}