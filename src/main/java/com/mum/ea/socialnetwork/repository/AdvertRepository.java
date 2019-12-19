package com.mum.ea.socialnetwork.repository;

import com.mum.ea.socialnetwork.domain.Advert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends CrudRepository<Advert,Long> {
}
