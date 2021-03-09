package com.ramonuribe.titangramws.io.repository;

import com.ramonuribe.titangramws.io.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {
}
