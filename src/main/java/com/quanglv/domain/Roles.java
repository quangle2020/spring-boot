package com.quanglv.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Roles extends AbstractAuditingEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "roles_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    @Column(name = "role_id", nullable = false)
    @NotNull
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_code")
    private String roleCode;

//    @ManyToMany(mappedBy = "roles")
//    private List<Users> users = new ArrayList<>();
}
