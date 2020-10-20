package com.quanglv.service;

import com.quanglv.domain.Roles;

import java.util.List;

public interface RolesService {
    List<Long> saveRoles(List<Roles> roles);
}
