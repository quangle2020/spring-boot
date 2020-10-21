package com.quanglv.service.mapper;

import com.quanglv.domain.Employees;
import com.quanglv.service.dto.EmployeesDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-21T09:13:41+0700",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class EmployeesMapperImpl implements EmployeesMapper {

    @Override
    public Employees toEntity(EmployeesDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Employees employees = new Employees();

        employees.setCreatedDate( dto.getCreatedDate() );
        employees.setCreatedUser( dto.getCreatedUser() );
        employees.setUpdatedDate( dto.getUpdatedDate() );
        employees.setUpdatedUser( dto.getUpdatedUser() );
        employees.setEmployeeId( dto.getEmployeeId() );
        employees.setNumberPhone( dto.getNumberPhone() );
        employees.setFullname( dto.getFullname() );
        employees.setAddress( dto.getAddress() );
        try {
            if ( dto.getBirthOfDate() != null ) {
                employees.setBirthOfDate( new SimpleDateFormat().parse( dto.getBirthOfDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        employees.setDepartmentId( dto.getDepartmentId() );
        employees.setEmail( dto.getEmail() );

        return employees;
    }

    @Override
    public EmployeesDTO toDto(Employees entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeesDTO employeesDTO = new EmployeesDTO();

        employeesDTO.setCreatedDate( entity.getCreatedDate() );
        employeesDTO.setCreatedUser( entity.getCreatedUser() );
        employeesDTO.setUpdatedDate( entity.getUpdatedDate() );
        employeesDTO.setUpdatedUser( entity.getUpdatedUser() );
        employeesDTO.setEmployeeId( entity.getEmployeeId() );
        employeesDTO.setNumberPhone( entity.getNumberPhone() );
        employeesDTO.setFullname( entity.getFullname() );
        employeesDTO.setAddress( entity.getAddress() );
        if ( entity.getBirthOfDate() != null ) {
            employeesDTO.setBirthOfDate( new SimpleDateFormat().format( entity.getBirthOfDate() ) );
        }
        employeesDTO.setDepartmentId( entity.getDepartmentId() );
        employeesDTO.setEmail( entity.getEmail() );

        return employeesDTO;
    }

    @Override
    public List<Employees> toEntity(List<EmployeesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Employees> list = new ArrayList<Employees>( dtoList.size() );
        for ( EmployeesDTO employeesDTO : dtoList ) {
            list.add( toEntity( employeesDTO ) );
        }

        return list;
    }

    @Override
    public List<EmployeesDTO> toDto(List<Employees> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmployeesDTO> list = new ArrayList<EmployeesDTO>( entityList.size() );
        for ( Employees employees : entityList ) {
            list.add( toDto( employees ) );
        }

        return list;
    }
}
