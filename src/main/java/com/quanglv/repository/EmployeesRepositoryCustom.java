package com.quanglv.repository;

import com.quanglv.service.dto.EmployeeCusDTO;

import java.util.List;

public interface EmployeesRepositoryCustom {
    /**
     *
     * @return
     */
    List<EmployeeCusDTO> getEmployeesCus();
}
