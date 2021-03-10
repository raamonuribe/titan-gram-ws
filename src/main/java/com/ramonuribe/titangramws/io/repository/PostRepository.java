package com.ramonuribe.titangramws.io.repository;

import com.ramonuribe.titangramws.io.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAll();
}
