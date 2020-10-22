package com.quanglv.web.rest;

import com.quanglv.service.EmployeesService;
import com.quanglv.service.dto.EmployeeCusDTO;
import com.quanglv.service.dto.GetEmployeesOutDTO;
import com.quanglv.web.rest.request.GetEmployeesRequest;
import com.quanglv.web.rest.request.UpdateEmployeesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/admin")
@RequestMapping("/")
public class EmployeesResource
{

    @Autowired
    private EmployeesService employeesService;

    /**
     * getEmployees
     * @return GetEmployeesOutDTO
     */
    @PostMapping(value = "/get-employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetEmployeesOutDTO> getEmployees(@RequestBody GetEmployeesRequest request) {
        return ResponseEntity.ok(employeesService.getEmployees(request.getEmployees(), request.getPage(), request.getSize()));
    }

    /**
     *
     * @return
     */
    @PostMapping(value = "/get-employeesCus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeCusDTO>> getEmployees() {
        return ResponseEntity.ok(employeesService.getEmployeesCus());
    }

    /**
     *
     * @return
     */
    @PostMapping(value = "/update_employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Long>> updateEmployees(@RequestBody UpdateEmployeesRequest request) {
        return ResponseEntity.ok(employeesService.saveEmployees(request.getEmployees()));
    }
}



