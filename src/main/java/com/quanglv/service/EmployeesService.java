package com.quanglv.service;

import com.quanglv.domain.Employees;
import com.quanglv.service.dto.EmployeeCusDTO;
import com.quanglv.service.dto.GetEmployeesOutDTO;

import java.util.List;

public interface EmployeesService {
    /**
     *
     * @param employeeIds
     * @return
     */
    GetEmployeesOutDTO getEmployees(List<Long> employeeIds, Long page, Long size);

    /**
     *
     * @return
     */
    List<EmployeeCusDTO> getEmployeesCus();

    /**
     *
     */
    List<Long> saveEmployees(List<Employees> employees);
}
