package com.mum.ea.socialnetwork.service;


import com.mum.ea.socialnetwork.domain.user_relation;

import java.util.List;

public interface user_relationService {
    void save(user_relation userRelation);
    long noOfFollowers_or_pendingRequest(int status);
    List<user_relation> getUserTypesByStatus(int status);
}
