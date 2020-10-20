package com.quanglv.repository;

import com.quanglv.domain.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    /**
     * findByEmployeeIdIn
     * @param employees
     * @return List<Employees>
     */
    List<Employees> findByEmployeeIdInOrderByEmployeeIdDesc(List<Long> employees);

    @Query(value = "SELECT * FROM EMPLOYEES", nativeQuery = true)
    List<Employees> getAll();
}
