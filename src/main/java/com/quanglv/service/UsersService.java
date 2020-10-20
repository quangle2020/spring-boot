package com.quanglv.service;

import com.quanglv.domain.Users;

import java.util.List;

public interface UsersService {

    /**
     * saveUsers
     * @param users
     * @return
     */
    List<Long> saveUsers(List<Users> users);
}
