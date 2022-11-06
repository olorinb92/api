package com.backend.api.repository;

import com.backend.api.model.PlayerModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<PlayerModel, String> {
    @Query(value = "{'name' : ?0}")
    PlayerModel findByName(String name);
}