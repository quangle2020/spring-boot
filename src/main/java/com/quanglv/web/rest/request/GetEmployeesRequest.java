package com.quanglv.web.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetEmployeesRequest implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -799639918082188588L;

    /**
     * employees
     */
    private List<Long> employees;

    private Long page;

    private Long size;
}
