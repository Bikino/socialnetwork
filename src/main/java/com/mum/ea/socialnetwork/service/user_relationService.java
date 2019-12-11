package com.mum.ea.socialnetwork.service;


import com.mum.ea.socialnetwork.domain.user_relation;

import java.util.List;

public interface user_relationService {
    public void save(user_relation userRelation);
    public long noOfFollowers_or_pendingRequest(int status);
    public List<user_relation> getUserTypesByStatus(int status);
}
