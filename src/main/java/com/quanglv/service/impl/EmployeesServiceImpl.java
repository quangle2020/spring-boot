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
        GetEmployeesOutDTO response = new GetEmployeesOutDTO();
        int pageConvert = page.intValue();
        int sizeConvert = size.intValue();
//        List<Users> user = usersRepository.findAll();
//        List<Roles> role = rolesRepository.findAll();
//        List<Employees> employees = employeesRepository.findByEmployeeIdInOrderByEmployeeIdDesc(employeeIds);
//        Page<Employees> pageE = employeesRepository.findAll(PageRequest.of(pageConvert, sizeConvert, Sort.by("employeeId").ascending()));
//        List<Employees> employees = employeesRepository.getAll();
        Page<Employees> pageE = employeesRepository.findAll(PageRequest.of(pageConvert - 1, sizeConvert));
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
//        response.setUsers(user);
//        response.setRoles(role);
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
