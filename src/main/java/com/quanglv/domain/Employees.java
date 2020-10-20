package com.quanglv.domain;

import com.quanglv.service.dto.EmployeeCusDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "employees")
@Data
@EqualsAndHashCode
@SqlResultSetMapping(name="GetEmployeeMapping",
        classes = {
                @ConstructorResult(
                        targetClass = EmployeeCusDTO.class,
                        columns = {
                                @ColumnResult(name = "fullname", type = String.class),
                                @ColumnResult(name = "number_phone", type = String.class)
                        })
        })
public class Employees extends AbstractAuditingEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "employees_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_seq")
    @Column(name = "employee_id", nullable = false)
    @NotNull
    private Long employeeId;

    /**
     * The Name
     */
    @Column(name = "number_phone")
    private String numberPhone;

    /**
     * The Name
     */
    @Column(name = "fullname")
    private String fullname;

    /**
     * The Name
     */
    @Column(name = "address")
    private String address;

    /**
     * The position order
     */
    @Column(name = "birth_of_date")
    private Date birthOfDate;

    /**
     * The use status
     */
    @Column(name = "department_id")
    private Long departmentId;

    /**
     *
     */
    @Column(name = "email")
    private String email;
}
