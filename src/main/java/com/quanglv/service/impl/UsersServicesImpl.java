package com.quanglv.service.impl;

import com.quanglv.domain.Users;
import com.quanglv.repository.UsersRepository;
import com.quanglv.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServicesImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Long> saveUsers(List<Users> users) {
        List<Long> response = new ArrayList<>();
        users.forEach(u ->{
            response.add(usersRepository.save(u).getUserId());
        });

        return response;
    }
}
