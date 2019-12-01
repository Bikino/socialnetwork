package com.mum.ea.socialnetwork.serviceImpl;

import com.mum.ea.socialnetwork.domain.user_relation;
import com.mum.ea.socialnetwork.repository.user_relationRepository;
import com.mum.ea.socialnetwork.service.user_relationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class user_relationServiceImpl implements user_relationService {

    @Autowired
    public user_relationRepository user_relation_repository;
    @Override
    public void save(user_relation userRelation) {
        user_relation_repository.save(userRelation);
    }
}
