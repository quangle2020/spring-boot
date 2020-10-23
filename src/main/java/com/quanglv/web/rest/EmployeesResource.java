package com.quanglv.web.rest;

import com.quanglv.service.EmployeesService;
import com.quanglv.service.dto.EmployeeCusDTO;
import com.quanglv.utils.CommonUtils;
import com.quanglv.utils.error.CustomException;
import com.quanglv.utils.error.CustomRestException;
import com.quanglv.web.rest.request.GetEmployeesRequest;
import com.quanglv.web.rest.request.UpdateEmployeesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
@RequestMapping("/")
public class EmployeesResource
{

    @Autowired
    private EmployeesService employeesService;

    /**
     * getEmployees
     * @return GetEmployeesOutDTO
     */
    @PostMapping(value = "/get-employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEmployees(@RequestBody GetEmployeesRequest request) throws CustomRestException {
        return ResponseEntity.ok(employeesService.getEmployees(request.getEmployees(), request.getPage(), request.getSize()));
    }
//    @PostMapping(value = "/get-employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public GetEmployeesOutDTO getEmployees(@RequestBody GetEmployeesRequest request) {
//        return employeesService.getEmployees(request.getEmployees(), request.getPage(), request.getSize());
//    }

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

    @PostMapping(value = "/hehe", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> hehe() throws CustomException{

        throw new CustomException("hehe","duoc khong");
    }

}



