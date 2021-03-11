package com.ramonuribe.titangramws.io.repository;

import com.ramonuribe.titangramws.io.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {

}
