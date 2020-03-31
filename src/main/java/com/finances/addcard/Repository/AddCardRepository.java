package com.finances.addcard.Repository;

import com.finances.addcard.Entity.AddCardEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddCardRepository extends MongoRepository<AddCardEntity,String>, QueryByExampleExecutor<AddCardEntity> {

    Optional<AddCardEntity> findByName(String name);
}
