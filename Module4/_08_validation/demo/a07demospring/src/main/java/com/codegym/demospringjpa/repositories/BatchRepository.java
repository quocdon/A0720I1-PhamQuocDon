package com.codegym.demospringjpa.repositories;

import com.codegym.demospringjpa.models.Batch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends CrudRepository<Batch,Integer> {
}
