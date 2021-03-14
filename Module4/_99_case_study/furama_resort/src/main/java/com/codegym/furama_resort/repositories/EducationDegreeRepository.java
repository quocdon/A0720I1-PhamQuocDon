package com.codegym.furama_resort.repositories;

import com.codegym.furama_resort.models.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
