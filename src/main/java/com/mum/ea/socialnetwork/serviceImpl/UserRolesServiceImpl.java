package com.mum.ea.socialnetwork.serviceImpl;

import com.mum.ea.socialnetwork.domain.UserRoles;
import com.mum.ea.socialnetwork.repository.UserRolesRepository;
import com.mum.ea.socialnetwork.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    private UserRolesRepository userRolesRepository;
    @Override
    public void saveUserRoles(UserRoles userRoles) {
            userRolesRepository.save(userRoles);
    }

}
