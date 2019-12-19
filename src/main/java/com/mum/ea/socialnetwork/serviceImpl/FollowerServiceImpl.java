package com.mum.ea.socialnetwork.serviceImpl;

import com.mum.ea.socialnetwork.domain.Follower;
import com.mum.ea.socialnetwork.repository.FollowerRepository;
import com.mum.ea.socialnetwork.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FollowerServiceImpl implements FollowerService {

    private FollowerRepository followerRepository;

    @Autowired
    public FollowerServiceImpl(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public List<Long> findAllByFolloweeIdEquals(Long id) {
        return followerRepository.findAllByFolloweeIdEquals(id);
    }

    @Override
    public List<Long> findAllByFollowerIdEquals(Long id) {
        return followerRepository.findAllByFollowerIdEquals(id);
    }

    @Override
    public Follower follow(Long followerId, Long followeeId) {
        Follower follower = new Follower();
        follower.setFolloweeId(followeeId);
        follower.setFollowerId(followerId);
        return followerRepository.save(follower);
    }
}
