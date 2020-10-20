package com.quanglv.web.rest.request;

import com.quanglv.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UpdateUsersRequest implements Serializable {

    private static final long serialVersionUID = 6641306186001226671L;
    private List<Users> users;
}
