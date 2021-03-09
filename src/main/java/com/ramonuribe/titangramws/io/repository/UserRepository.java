package com.ramonuribe.titangramws.io.repository;

import com.ramonuribe.titangramws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    List<UserEntity> findAll();
    UserEntity findByUserId(String userId);
}
