package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.user_relation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface user_relationRepository extends CrudRepository<user_relation, Long> {

    @Query(value = "SELECT count(*) FROM user_relation  WHERE status = :status", nativeQuery = true)
    public long noOfFollowers_or_pendingRequest(@PathParam("status") int status);

    @Query("SELECT ur FROM user_relation ur WHERE status = :status")
    public List<user_relation> getUserTypesByStatus(@PathParam("status") int status);

}
