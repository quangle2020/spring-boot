package com.quanglv.repository.imp;

import com.quanglv.repository.EmployeesRepositoryCustom;
import com.quanglv.service.dto.EmployeeCusDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeesRepositoryCustomImpl implements EmployeesRepositoryCustom {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<EmployeeCusDTO> getEmployeesCus() {
        StringBuilder sql = new StringBuilder("SELECT e.fullname, e.number_phone ");
        sql.append("FROM employees e");
        Query query = manager.createNativeQuery(sql.toString(), "GetEmployeeMapping");
        return query.getResultList();
    }
}
