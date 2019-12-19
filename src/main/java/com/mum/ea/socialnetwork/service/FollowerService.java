package com.mum.ea.socialnetwork.service;

import com.mum.ea.socialnetwork.domain.Follower;

import java.util.List;

public interface FollowerService {

    List<Long> findAllByFolloweeIdEquals(Long id);
    List<Long> findAllByFollowerIdEquals(Long id);
    Follower follow(Long followerId, Long followeeId);

}
