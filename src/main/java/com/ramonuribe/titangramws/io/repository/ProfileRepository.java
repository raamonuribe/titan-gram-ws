package com.ramonuribe.titangramws.io.repository;

import com.ramonuribe.titangramws.io.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {
    ProfileEntity findByProfileId(String profileId);
    List<ProfileEntity> findAll();
}
