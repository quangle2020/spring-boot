package com.quanglv.service.mapper;

import com.quanglv.domain.Employees;
import com.quanglv.service.dto.EmployeesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeesMapper extends EntityMapper<EmployeesDTO, Employees> {
}
//đủ hết rồi mà
