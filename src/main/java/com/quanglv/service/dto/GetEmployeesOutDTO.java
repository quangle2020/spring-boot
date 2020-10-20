package com.quanglv.service.dto;

import com.quanglv.domain.Roles;
import com.quanglv.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeesOutDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7078614004848305958L;

    /**
     * list employee
     */
    private List<EmployeesDTO> employees;

    private List<Users> users;

    private List<Roles> roles;
}
