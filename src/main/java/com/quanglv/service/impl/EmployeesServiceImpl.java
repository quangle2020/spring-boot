package com.quanglv.service.impl;

import com.quanglv.domain.Employees;
import com.quanglv.repository.EmployeesRepository;
import com.quanglv.repository.EmployeesRepositoryCustom;
import com.quanglv.repository.RolesRepository;
import com.quanglv.repository.UsersRepository;
import com.quanglv.service.EmployeesService;
import com.quanglv.service.dto.EmployeeCusDTO;
import com.quanglv.service.dto.EmployeesDTO;
import com.quanglv.service.dto.GetEmployeesOutDTO;
import com.quanglv.utils.CommonUtils;
import com.quanglv.utils.error.BadRequestAlertException;
import com.quanglv.utils.error.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private EmployeesRepositoryCustom employeesRepositoryCustom;

    /**
     * getEmployees
     *
     * @param employeeIds
     * @return
     */
    @Override
    public GetEmployeesOutDTO getEmployees(List<Long> employeeIds, Long page, Long size) {
        if (employeeIds == null || employeeIds.size() == 0) {
            throw new CustomException("err validate", CommonUtils.putError("no param","ERR_002"));
        }

        GetEmployeesOutDTO response = new GetEmployeesOutDTO();
        Page<Employees> pageE = employeesRepository.findAll(PageRequest.of(page.intValue() - 1, size.intValue()));
        List<EmployeesDTO> listEmployee = new ArrayList<>();
        pageE.forEach(e -> {
            EmployeesDTO dto = new EmployeesDTO();
            dto.setEmployeeId(e.getEmployeeId());
            dto.setNumberPhone(e.getNumberPhone());
            dto.setFullname(e.getFullname());
            dto.setAddress(e.getAddress());
            dto.setBirthOfDate(e.getBirthOfDate().toString());
            dto.setDepartmentId(e.getDepartmentId());
            dto.setCreatedDate(e.getCreatedDate());
            dto.setCreatedUser(e.getCreatedUser());
            dto.setUpdatedDate(e.getUpdatedDate());
            dto.setUpdatedUser(e.getUpdatedUser());
            dto.setEmail(e.getEmail());
            listEmployee.add(dto);
        });
        response.setEmployees(listEmployee);
        return response;
    }

    /**
     *
     * @return
     */
    @Override
    public List<EmployeeCusDTO> getEmployeesCus() {
        return employeesRepositoryCustom.getEmployeesCus();
    }

    /**
     *
     * @param employees
     * @return
     */
    @Override
    public List<Long> saveEmployees(List<Employees> employees) {
        List<Long> response = new ArrayList<>();
        List<Employees> lstEm = employeesRepository.saveAll(employees);
        lstEm.forEach(e ->{
            response.add(e.getEmployeeId());
        });
        return response;
    }
}
