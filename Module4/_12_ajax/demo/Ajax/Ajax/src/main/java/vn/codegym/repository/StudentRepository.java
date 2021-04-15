package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.name =:input and s.id >=2")
    Page<Student> findByName2(@Param("input") String name, Pageable pageable);
}
