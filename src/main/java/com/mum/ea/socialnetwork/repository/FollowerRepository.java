package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.Follower;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends CrudRepository<Follower, Long> {

    @Query("select f.followerId from Follower f where f.followeeId = ?1")
    List<Long> findAllByFolloweeIdEquals(Long id);
    @Query("select f.followeeId from Follower f where f.followerId = ?1")
    List<Long> findAllByFollowerIdEquals(Long id);

}
