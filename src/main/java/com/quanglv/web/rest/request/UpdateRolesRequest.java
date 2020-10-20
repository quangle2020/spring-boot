package com.quanglv.web.rest.request;

import com.quanglv.domain.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UpdateRolesRequest {
    private List<Roles> roles;
}
